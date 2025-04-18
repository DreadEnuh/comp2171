package user_management;

public class User {
    private String userID;
    private String userName, key;

    public User() {
    }

    public User(String userID, String userName, String key) {
        this.userID = userID;
        this.userName = userName;
        this.key = AuthService.encryptString(key);
    }

    // Getters

    public String getID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getKey() {
        return key;
    }

    // Setters

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
