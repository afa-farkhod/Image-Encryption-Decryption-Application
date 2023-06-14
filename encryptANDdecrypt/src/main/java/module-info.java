module com.example.encryptanddecrypt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.encryptanddecrypt to javafx.fxml;
    exports com.example.encryptanddecrypt;
}