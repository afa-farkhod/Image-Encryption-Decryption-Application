# Image-Encryption-Decryption-Application
Application provides a user-friendly interface for encrypting and decrypting image files using AES algorithm

- [Advanced Encryption Standard](https://www.tutorialspoint.com/cryptography/advanced_encryption_standard.htm) - AES (Advanced Encryption Standard) is a widely used symmetric encryption algorithm that provides secure and efficient data encryption and decryption.
- AES operates on blocks of data, where each block is 128 bits (16 bytes) in size. It supports three key lengths: 128-bit, 192-bit, and 256-bit. The algorithm consists of several rounds of substitution, permutation, and mixing operations, making it highly resistant to cryptographic attacks.

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a6a21911-d0b3-4585-9dce-39d7262dcbd3" alt="Image">
</p>

- The basic steps of the AES algorithm are as follows:
     - Key Expansion: Generates a set of round keys from the original encryption key.
     - Initial Round: XORs the input data with the first round key.
     - Rounds: Consists of multiple rounds (9, 11, or 13 rounds depending on the key length). Each round applies a series of transformations to the data, including byte substitution, row shifting, column mixing, and XORing with a round key.
     - Final Round: Performs the last round of transformations without the column mixing step.
     - Output: The final encrypted (or decrypted) data is obtained.
- AES is known for its strong security, efficiency, and versatility. It is widely used in various applications, including secure communication, data storage, and cryptographic protocols.
- Encryption Process
     - Here, we restrict to description of a typical round of AES encryption. Each round comprise of four sub-processes. The first round process is depicted below
 
       ![first_round_process](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/293c46de-2198-44d1-9272-355be1bc2459)

---------------------------------

## [Implementation](https://github.com/af4092/Image-Encryption-Decryption-Application/tree/main/encryptANDdecrypt/src/main/java/com/example/encryptanddecrypt)

- This sample code represents an Encryption and Decryption application that allows users to encrypt and decrypt image files using the AES encryption algorithm. The application has a graphical user interface (GUI) built using JavaFX.
- The main functionalities of the application include:
- Encryption:
    - When the user clicks the "Encrypt Doc" button, a file selection dialog is displayed for the user to choose an image file.
    - After selecting the file, a dialog prompts the user to enter an encryption key.
    - The entered key is validated and padded if necessary to match the required key length for AES (128 bits).
    - The selected file is read, and its contents are encrypted using the encryption key and the AES algorithm.
    - The encrypted image is saved to a new file named "encrypted_" followed by the original file name.
    - The encrypted image is then displayed in a separate window.
- Decryption:
    - When the user clicks the "Decrypt Doc" button, a dialog is displayed to enter the decryption key.
    - The entered key is validated and padded if necessary to match the required key length for AES.
    - The selected encrypted image file is read.
    - The encrypted data is decrypted using the decryption key and the AES algorithm.
    - The decrypted data is saved to a new file named "decrypted_" followed by the original file name.
    - The decrypted image is then displayed in a separate window.
- GUI:
    - The GUI consists of a main window with two buttons: "Encrypt Doc" and "Decrypt Doc".
    - When a user drags and drops an image file onto the main window, the file is selected, and its image is displayed.
    - The selected file is stored in the selectedFile variable for later encryption or decryption.
    - Overall, this application provides a user-friendly interface for encrypting and decrypting image files using AES encryption.

- Main window:

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/577b2e05-a9dd-4221-9760-45ba36a25a4e" alt="Image">
</p>

- After Drag & Dropping the sample image we press the `Encrypt Doc` button

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a0ba1833-33b7-4f6c-afaf-1c48fe6d2d73" alt="Image">
</p>

- After that `Encryption Key` window appears, and asks to enter Key:

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/4c662832-e903-4add-b4ef-7c14f18e1fa3" alt="Image">
</p>

- To enter the key, we run another Java Api to randomly generate key `RandomKeyGenerator`

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/edafc24f-751c-4d39-aa5f-92081f67f5bb" alt="Image">
</p>

- Then we Copy Paste the Randomly generate key then press Ok:

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a3d00842-3d50-47b0-b360-c1b3f8635796" alt="Image">
</p>

- Then encrypted image appears in the project's directory with the following name `encrypted_Capture.JPG`

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/96dc7452-fba3-4301-8c72-1bc028eebe83" alt="Image">
</p>

- To decrypt the image, we Drag & Drop the encrypted image file to the Main window and press the `Decrypt Doc` button, then it asks for `Decryption Key`, as we are using Symmetric Key , we decrypt the image with the same key as the encrpytion key:

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/482c63fc-5254-479a-a542-b6f32614ea42" alt="Image">
</p>

- And now decrypted image again appears in the project directory with the name `decrypted_encrypted_Capture.JPG`

<p align="center">
  <img src="https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/53139618-27d3-4991-8510-734be9a2cf91" alt="Image">
</p>
