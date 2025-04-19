package user_management;

public class User {
    private String userID, password;

    public User() {
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = AuthService.encryptString(password);
    }

    // Load Constructor (prevents rehashing of already hashed password)
    public User(String userID) {
        this.userID = userID;
    }

    // Getters

    public String getID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setUserID(String newID) {
        this.userID = newID;
    }

    public void setPassword(String encPassword) {
        this.password = encPassword;
    }

}
