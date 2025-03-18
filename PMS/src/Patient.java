import java.time.LocalDate;
import java.time.Period;

public class Patient implements Comparable<Patient>{
    private String patientID, fName, mName, lName;
    private MedicalHistory medHistory;
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
        this.medHistory = new MedicalHistory();

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

    public MedicalHistory getMedicalHistory() {
        return medHistory;
    }

    public void addCondition(String condition) {
        this.medHistory.addCondition(condition);
    }

    public int getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
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
        return "\n==============================================\n"
                + "ID: " + this.getPatientID()
                + "\nName: " + this.getFName() + " " + this.getMName() + " " + this.getLName()
                + "\nDOB: " + this.getDob()
                + "\nAge: " + this.getAge()
                + this.getMedicalHistory()
                + "\n==============================================\n";
    }

    @Override
    public int compareTo(Patient o) {
        return this.getLName().compareTo(o.getLName());
    }

    public static void main(String[] args) {

        Patient p1 = new Patient("Alice", "Marie", "Johnson", "5", "7", "1990");
        Patient p2 = new Patient("Bob", "Edward", "Smith", "12", "3", "1985");
        Patient p3 = new Patient("Charlie", "James", "Brown", "25", "11", "1992");
        Patient p4 = new Patient("Diana", "Louise", "Clark", "8", "6", "1988");
        Patient p5 = new Patient("Ethan", "Michael", "Davis", "19", "9", "1995");

        // Adding medical conditions
        p1.medHistory.addCondition("Asthma");
        p2.medHistory.addCondition("Diabetes");
        p2.addCondition("Hypertension");
        p2.addCondition("Pancreatic Cancer");
        p3.medHistory.addCondition("Hypertension");
        p4.medHistory.addCondition("Migraine");
        p5.medHistory.addCondition("High Cholesterol");

        // Adding visit history
        p1.medHistory.addVisitInfo("10", "02", "2024", "Moderate", "Shortness of breath", "Asthma attack", "Inhaler prescribed");
        p2.medHistory.addVisitInfo("15", "03", "2023", "Severe", "High blood sugar", "Type 2 Diabetes", "Insulin therapy");
        p3.medHistory.addVisitInfo("05", "04", "2024", "Mild", "Routine check-up", "Stable", "Continue medication");
        p4.medHistory.addVisitInfo("20", "01", "2024", "Moderate", "Severe headache", "Chronic Migraine", "Prescription for pain relief");
        p5.medHistory.addVisitInfo("08", "06", "2023", "Mild", "Routine cholesterol test", "Elevated cholesterol", "Diet and exercise recommended");

        Patient[] patients = {p1, p2, p3, p4, p5};

        // Printing details of each patient
        for (Patient p : patients) {
            System.out.println(p);
        }

    }

}
