package user_management;

import database.DBConnection;
import database.DoctorDatabase;
import database.ReceptionistDatabase;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.passay.WhitespaceRule.ERROR_CODE;

public class AuthService {
    private static SecretKey authKey;
    private static final Cipher desCipher;
    private static final String KEY_NAME = "auth_key";

    private static final DoctorDatabase ddb;
    private static final ReceptionistDatabase rdb;

    private static ArrayList<User> users = new ArrayList<>();
    private static final Dictionary<String, String> usersDict;

    static {
        try {
            desCipher = Cipher.getInstance("DES");
            authKey = DBConnection.loadKey(KEY_NAME);
            if (authKey == null) {
                KeyGenerator keyGen = KeyGenerator.getInstance("DES");
                authKey = keyGen.generateKey();
                DBConnection.saveKey(authKey, KEY_NAME);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error initializing AuthService", e);
        }

        ddb = new DoctorDatabase();
        rdb = new ReceptionistDatabase();

        usersDict = new Hashtable<>();
        users = DBConnection.loadUsers();

        for (User u: users) {
            usersDict.put(u.getID(), u.getPassword());
        }

    }


    // Constructor
    public AuthService() {
    }


    // Getters
    public static Dictionary<String, String> getUsersDict() {
        return usersDict;
    }

    public static Enumeration<String> getUsernames() {
        return usersDict.keys();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUserByID(String uid) {
        for (User u:users) {
            if (u.getID().equals(uid)) {
                return u;
            }
        }
        return null;
    }

    public static DoctorDatabase getDdb() {
        return ddb;
    }

    public static ReceptionistDatabase getRdb() {
        return rdb;
    }

    public static SecretKey getAuthKey() {
        return authKey;
    }

    public static Cipher getDesCipher() {
        return desCipher;
    }

    // Modifiers
    public static void addUserCredentials(String username, String passphrase) {
        usersDict.put(username, passphrase);
    }

    public static void deleteUserCredentials(String username) {
        usersDict.remove(username);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static boolean updateUser(String userID, String uid, String password) {
        User user = getUserByID(userID);

        if (user == null) {
            return false;
        }

        user.setUserID(uid);
        user.setPassword(encryptString(password));
        return true;
    }

    public static void deleteUser(User user) {
        users.remove(user);
    }

    // Predicates
    public static boolean verifyUserID(String userID) {
        return usersDict.get(userID) != null;
    }

    public static boolean verifyPassphrase(String userID, String passphrase) {
        return encryptString(passphrase).equals(usersDict.get(userID));
    }

    public static boolean validateUserIDFormat(String userID) {
        userID = userID.replace("-", "");

        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        if ((userID.length() == 7) || (userID.length() == 8)) {
            if (userID.charAt(0) == 'D') {
                String lSub = userID.substring(1,5);
                System.out.println(lSub);
                Matcher hasDigit = digit.matcher(lSub);
                Matcher hasSpecial = special.matcher(lSub);

                String nSub = userID.substring(5, 8);
                System.out.println(nSub);
                Matcher hasLetter = letter.matcher(nSub);
                Matcher hasSpecial2 = special.matcher(nSub);

                return (!hasSpecial.find()) && (!hasDigit.find()) && (!hasSpecial2.find()) && (!hasLetter.find());
            } else if (userID.charAt(0) == 'R') {
                String lSub = userID.substring(1, 4);
                Matcher hasDigit = digit.matcher(lSub);
                Matcher hasSpecial = special.matcher(lSub);

                String nSub = userID.substring(4, 7);
                Matcher hasLetter = letter.matcher(nSub);
                Matcher hasSpecial2 = special.matcher(nSub);

                return (!hasSpecial.find()) && (!hasDigit.find()) && (!hasSpecial2.find()) && (!hasLetter.find());
            }
        }
        return false;
    }

    public static boolean validatePasswordFormat(String password) {
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        return (password.length() >= 8) && hasLetter.find();
    }

    // Functionality
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

    public static String decryptString(String encryptedText) {
        String retVal = "";

        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
            desCipher.init(Cipher.DECRYPT_MODE, authKey);
            byte[] decryptedBytes = desCipher.doFinal(encryptedBytes);
            retVal = new String(decryptedBytes, StandardCharsets.UTF_8);

        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.fillInStackTrace();
        }

        return retVal;
    }

    public static String generatePassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        return gen.generatePassword(10, splCharRule, lowerCaseRule, upperCaseRule, digitRule);
    }

    public static void main(String[] args) {
        System.out.println("AuthService Class");
    }

}
