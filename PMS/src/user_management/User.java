package user_management;

public abstract class User {
    private String fName, mName, lName, id, userName;

    public User() {

    }
    public User(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.userName = "";
        this.id = "";
    }

    // Getters

    public String getFName() {
        return fName;
    }

    public String getMName() {
        return mName;
    }

    public String getLName() {
        return lName;
    }

    public abstract String getID();

    public String getUserName() {
        return userName;
    }

    // Setters

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
