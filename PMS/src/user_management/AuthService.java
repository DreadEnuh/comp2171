package user_management;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AuthService {
    private final Dictionary<String, String> users;
    private SecretKey authKey;
    private Cipher desCipher;


    // Constructor
    public AuthService() {
        users = new Hashtable<>();
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            authKey = keyGen.generateKey();
            desCipher = Cipher.getInstance("DES");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException nsae) {
            nsae.fillInStackTrace();
        }
    }

    // Getters
    public Dictionary<String, String> getUsers() {
        return users;
    }

    public Enumeration<String> getUsernames() {
        return users.keys();
    }

    // Modifiers
    public void addUser(String username, String passphrase) {
        String p = encryptString(passphrase);
        users.put(username, p);
    }

    public void deleteUser(String username) {
        users.remove(username);
    }

    // Predicates
    public boolean verifyUsername(String username) {
        return users.get(username) != null;
    }

    public boolean verifyPassphrase(String username, String passphrase) {
        return encryptString(passphrase).equals(users.get(username));
    }

    // Other
    public String encryptString(String plaintext) {
        String retVal = " ";

        try {
            byte[] plainBytes = plaintext.getBytes(StandardCharsets.UTF_8);
            desCipher.init(Cipher.ENCRYPT_MODE, authKey);
            byte[] cryptText = desCipher.doFinal(plainBytes);
            retVal = Base64.getEncoder().encodeToString(cryptText);

        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.fillInStackTrace();
        }

        return retVal;
    }

    public static void main(String[] args) {
        System.out.println("AuthService Class");
    }

}
