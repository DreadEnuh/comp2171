package user_management;

public class Receptionist {
    private String fName, mName, lName;
    private String rID;
    private Role role;
    private static int numReceptionists = 1;

    public Receptionist() {
    }
    public Receptionist(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        String format = String.format("%03d", numReceptionists);
        this.rID = "R-" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0) + String.format(format, numReceptionists);
        this.role = new Role("Spectator");
        AuthService.addUser(new User(rID, AuthService.generatePassword()));
        numReceptionists ++;
    }

    // Load Constructor
    public Receptionist(String rid, String fName, String mName, String lName, String roleTitle) {
        this.rID = rid;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        numReceptionists ++;
        this.role = new Role(roleTitle);
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

    public String getID() {
        return rID;
    }

    public Role getRole() {
        return role;
    }

    public static int getNumReceptionists() {
        return numReceptionists;
    }

    // Setters

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void generateNewID() {
        String format = String.format("%03d", numReceptionists);
        this.rID = "R-" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0) + String.format(format, numReceptionists);
    }

}
