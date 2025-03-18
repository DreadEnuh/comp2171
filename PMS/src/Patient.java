import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient implements Comparable<Patient>{
    private String patientID, fName, mName, lName;
    private static int patientNumber;
    private LocalDate dob;

    public Patient(){}
    public Patient(String fName, String mName, String lName, String dd, String mm, String yyyy) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        dd = (dd.length() == 1)? ("0" + dd):(dd);
        mm = (mm.length() == 1)? ("0" + mm):(mm);
        String dateString = yyyy + "-" + mm + "-" + dd;
        dob = LocalDate.parse(dateString);

        patientID = "" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0) + "000" + patientNumber;
        patientNumber ++;
    }

    public String getPatientID(){
        return patientID;
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

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return LocalDate.now().compareTo(getDob());
    }

    public void setFName(String newFName) {
        this.fName = newFName;
    }

    public void setMName(String newMName) {
        this.mName = newMName;
    }

    public void setLName(String newLName) {
        this.lName = newLName;
    }

    public String toString() {
        String retString = "\n----------------------------------\n"
                + "ID: " + this.getPatientID()
                + "\nName: " + this.getFName() + " " + this.getMName() + " " + this.getLName()
                + "\nDOB: " + this.getDob()
                + "\nAge: " + this.getAge()
                + "\n----------------------------------\n";
        return retString;
    }

    @Override
    public int compareTo(Patient o) {
        return this.getLName().compareTo(o.getLName());
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Tod", "George", "Tables", "17", "3", "1992");
        System.out.println(p1);
        Patient p2 = new Patient("Jillian", "May", "Cross", "9", "08", "1959");
        System.out.println(p2);
    }

}
