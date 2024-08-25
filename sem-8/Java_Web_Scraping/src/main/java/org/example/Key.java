package org.example;


/*
 * @author : rabin
 */
import java.security.SecureRandom;
import java.util.Base64;

public class Key {

    public static void main(String[] args) {
        // Generate a secure random key
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits key
        secureRandom.nextBytes(key);

        // Encode the key to Base64
        String base64Key = Base64.getEncoder().encodeToString(key);

        // Print the key
        System.out.println("Generated JWT Secret: " + base64Key);
    }
}
