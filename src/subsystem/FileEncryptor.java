package subsystem;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiantes
 */
public class FileEncryptor {
        private static String  ENCRYPT_KEY="clave-compartida-no-reveloar-nunca";

    private static String encript(String text) throws Exception {	
	Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.ENCRYPT_MODE, aesKey);

	byte[] encrypted = cipher.doFinal(text.getBytes());
		
	return Base64.getEncoder().encodeToString(encrypted);
	}

    private static String decrypt(String encrypted) throws Exception {
	Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] encryptedBytes=cipher.doFinal(Base64.getDecoder().decode(encrypted));

	String decrypted = new String(cipher.doFinal(encryptedBytes));
        
	return decrypted;
	}
    
}
