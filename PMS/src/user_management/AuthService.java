package user_management;

import appointment_management.DoctorService;
import database.DBConnection;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthService {
    private final DoctorService ds = new DoctorService();
    private ArrayList<User> users = new ArrayList<>();
    private final Dictionary<String, String> usersDict;
    private static SecretKey authKey;
    private static Cipher desCipher;


    // Constructor
    public AuthService() {
        usersDict = new Hashtable<>();
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            authKey = keyGen.generateKey();
            desCipher = Cipher.getInstance("DES");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException nsae) {
            nsae.fillInStackTrace();
        }

        users = DBConnection.loadUsers();
        for (User u: users) {
            usersDict.put(u.getUserName(), u.getKey());
        }
    }

    // Getters
    public Dictionary<String, String> getUsersDict() {
        return usersDict;
    }

    public Enumeration<String> getUsernames() {
        return usersDict.keys();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    // Modifiers
    public void addUser(String username, String passphrase) {
        String p = encryptString(passphrase);
        usersDict.put(username, p);
    }

    public void deleteUser(String username) {
        usersDict.remove(username);
    }

    // Predicates
    public boolean verifyUsername(String username) {
        return usersDict.get(username) != null;
    }

    public boolean verifyPassphrase(String username, String passphrase) {
        return encryptString(passphrase).equals(usersDict.get(username));
    }

    public static boolean validateUsernameFormat(String username) {
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetter = letter.matcher(username);
        Matcher hasDigit = digit.matcher(username);
        Matcher hasSpecial = special.matcher(username);

        return (username.length() > 5) && (Character.isAlphabetic(username.charAt(0))) && hasLetter.find() && hasDigit.find() && !hasSpecial.find();
    }

    public static boolean validatePasswordFormat(String password) {
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        return (password.length() >= 8) && hasLetter.find() && hasDigit.find() && hasSpecial.find();
    }

    // Other
    public static String encryptString(String plaintext) {
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
        AuthService pmsAuth = new AuthService();
        pmsAuth.addUser("lindsaya101", "Ilovebluecheese!");
        System.out.println(pmsAuth.getUsersDict());
    }

}
