package user_management;

public class Receptionist extends User {
    private String fName, mName, lName;
    private String rID;
    private static int numReceptionists = 1;

    public Receptionist() {
    }
    public Receptionist(String fName, String mName, String lName) {
        super(fName, mName, lName);
        String format = String.format("%03d", numReceptionists);
        this.rID = "R-" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0) + String.format(format, numReceptionists);
        numReceptionists ++;
    }

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

    public static int getNumReceptionists() {
        return numReceptionists;
    }
}
