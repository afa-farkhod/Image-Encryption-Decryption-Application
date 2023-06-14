# Image-Encryption-Decryption-Application
Application provides a user-friendly interface for encrypting and decrypting image files using AES algorithm

- [Advanced Encryption Standard](https://www.tutorialspoint.com/cryptography/advanced_encryption_standard.htm) - AES (Advanced Encryption Standard) is a widely used symmetric encryption algorithm that provides secure and efficient data encryption and decryption.
- AES operates on blocks of data, where each block is 128 bits (16 bytes) in size. It supports three key lengths: 128-bit, 192-bit, and 256-bit. The algorithm consists of several rounds of substitution, permutation, and mixing operations, making it highly resistant to cryptographic attacks.

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a6a21911-d0b3-4585-9dce-39d7262dcbd3)

---------------------------------

## Implementation

- Main window:

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/577b2e05-a9dd-4221-9760-45ba36a25a4e)

- After Drag & Dropping the sample image we press the `Encrypt Doc` button

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a0ba1833-33b7-4f6c-afaf-1c48fe6d2d73)

- After that `Encryption Key` window appears, and asks to enter Key:

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/4c662832-e903-4add-b4ef-7c14f18e1fa3)

- To enter the key, we another Java Api to randomly generate key `RandomKeyGenerator`

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/edafc24f-751c-4d39-aa5f-92081f67f5bb)

- Then we Copy Paste the Randomly generate key then press Ok:

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/a3d00842-3d50-47b0-b360-c1b3f8635796)

- Then encrypted image appears in the project's directory with the following name `encrypted_Capture.JPG`

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/96dc7452-fba3-4301-8c72-1bc028eebe83)

- To decrypt the image, we Drag & Drop the encrypted image file to the Main window and press the `Decrypt Doc` button, then it asks for `Decryption Key`, as we are using Symmetric Key , we decrypted the image with the encrpytion key:

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/482c63fc-5254-479a-a542-b6f32614ea42)

- And now decrypted image again appears in the project directory with the name `decrypted_encrypted_Capture.JPG`

![image](https://github.com/af4092/Image-Encryption-Decryption-Application/assets/24220136/53139618-27d3-4991-8510-734be9a2cf91)




