package com.example.encryptanddecrypt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

public class EncryptionDecryptionApp extends Application {

    private static final String ENCRYPTION_ALGORITHM = "AES";

    private File selectedFile;
    private byte[] encryptionKey;
    private Button encryptButton;
    private Button decryptButton;
    private ImageView imageView;

    private void encryptImage(File file) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Encryption Key");
        dialog.setHeaderText("Enter the encryption key:");
        dialog.setContentText("Key:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(key -> {
            try {
                encryptionKey = validateAndPadKey(key);
                byte[] encryptedImage = encryptData(readFile(file), encryptionKey);
                saveEncryptedImage(file, encryptedImage);
                showImage(new File("encrypted_" + file.getName()));
            } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException
                     | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        });
    }

    private byte[] validateAndPadKey(String key) {
        byte[] paddedKey = new byte[16];  // AES 128-bit key length
        byte[] originalKey = key.getBytes();
        int length = originalKey.length;

        if (length > 16) {
            System.arraycopy(originalKey, 0, paddedKey, 0, 16);
        } else if (length < 16) {

            System.arraycopy(originalKey, 0, paddedKey, 0, length);
        } else {
            // Key length is already valid
            paddedKey = originalKey;
        }

        return paddedKey;
    }
        private byte[] readFile(File file) throws IOException {
            try (InputStream is = new FileInputStream(file)) {
                byte[] data = new byte[(int) file.length()];
                is.read(data);
                return data;
            }
        }

        private void saveEncryptedImage(File originalFile, byte[] encryptedData) throws IOException {
            String encryptedFileName = "encrypted_" + originalFile.getName();
            try (OutputStream os = new FileOutputStream(encryptedFileName)) {
                byte[] encodedData = Base64.getEncoder().encode(encryptedData);
                os.write(encryptedData);
            }
        }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Encryption&Decryption App");

        encryptButton = new Button("Encrypt Doc");
        encryptButton.setOnAction(e -> encryptImage(selectedFile));

        decryptButton = new Button("Decrypt Doc");
        decryptButton.setOnAction(e -> decryptImage());

        Label infoLabel = new Label("Drag and drop the Doc file here");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(infoLabel, encryptButton, decryptButton);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 400, 200);

        // Set up drag-and-drop functionality
        scene.setOnDragOver(event -> {
            if (event.getGestureSource() != this &&
                    event.getDragboard().hasFiles()) {
                event.acceptTransferModes(javafx.scene.input.TransferMode.COPY);
            }
            event.consume();
        });

        scene.setOnDragDropped(event -> {
            var db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                selectedFile = db.getFiles().get(0);
                success = true;
                showImage(selectedFile);
            }
            event.setDropCompleted(success);
            event.consume();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void decryptImage() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Decryption Key");
        dialog.setHeaderText("Enter the decryption key:");
        dialog.setContentText("Key:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(key -> {
            try {
                // Validate key length and pad if necessary
                byte[] paddedKey = validateAndPadKey(key);

                byte[] encryptedData = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                byte[] decryptedData = decryptData(encryptedData, paddedKey);
                File decryptedFile = new File("decrypted_" + selectedFile.getName());
                FileOutputStream outputStream = new FileOutputStream(decryptedFile);
                outputStream.write(decryptedData);
                outputStream.close();
                showImage(decryptedFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private byte[] encryptData(byte[] data, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    private byte[] decryptData(byte[] encryptedData, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(encryptedData);
    }

    private void showImage(File file) {
        Image image = new Image(file.toURI().toString());
        imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, encryptButton, decryptButton);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 400, 300);

        Stage stage = new Stage();
        stage.setTitle("Image Viewer");
        stage.setScene(scene);
        stage.show();
    }
  }