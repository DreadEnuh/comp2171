package patient_management;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient implements Comparable<Patient>{
    private String patientID, fName, mName, lName, gender, emailAddress, contactNo, address;
    private int age;
    private MedicalHistory medHistory;
    private static int numPatients = 1;
    private LocalDate dob;

    public Patient(){}
    public Patient(String pid, String fName, String mName, String lName, String gender, LocalDate dob, String emailAddress, String contactNo, String address) {
        this.patientID = pid;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.gender = gender;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.contactNo = contactNo;
        this.address = address;
        numPatients++;
    }
    public Patient(String fName, String mName, String lName, String gender, LocalDate dob, String emailAddress, String contactNo, String address) {
        this.fName = fName.toUpperCase();
        this.mName = mName.toUpperCase();
        this.lName = lName.toUpperCase();
        this.gender = gender;
        this.dob = dob;
        this.age = Period.between(getDob(), LocalDate.now()).getYears();
        this.emailAddress = emailAddress;
        this.contactNo = contactNo;
        this.address = address;
        this.medHistory = new MedicalHistory(patientID);
        String format = String.format("%06d", numPatients);
        patientID = "P-" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0) + String.format(format, numPatients);
        numPatients++;
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

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public MedicalHistory getMedicalHistory() {
        return medHistory;
    }

    public ArrayList<String> getConditions() {
        return medHistory.getConditions();
    }

    public ArrayList<String> getVisitsInfo() {
        return medHistory.getVisitsInfo();
    }

    public int getNumVisits() {
        return medHistory.getNumVisits();
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fName + " " + mName + " " + lName;
    }

    public static int getNumPatients() {
        return numPatients;
    }

    // Setters

    public void addCondition(String condition) {
        this.medHistory.addCondition(condition);
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPatientID(String pid) {
        this.patientID = pid;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNo = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addVisitInfo(String dd, String mm, String yyyy, String severity, String problemDescription, String diagnosis, String treatment) {
        dd = (dd.length() == 1)? ("0" + dd):(dd);
        mm = (mm.length() == 1)? ("0" + mm):(mm);
        String visitDate = yyyy + "-" + mm + "-" + dd;

        String visitEntry = "Visit number: " + medHistory.getNumVisits() + " on " + visitDate + " for " + problemDescription
                + "\nSeverity: " + severity.toUpperCase()
                + "\nDiagnosis: " + diagnosis
                + "\nTreatment: " + treatment;
        medHistory.addVisitInfo(visitEntry);
    }

    public void setMedHistory(MedicalHistory mh) {
        this.medHistory = mh;
    }

    public static void setNumPatients(int pNum) {
        numPatients = pNum;
    }

    public String toString() {
        return "\n======================================================================\n"
                + "ID: " + this.getPatientID()
                + "\nName: " + this.getFName() + " " + this.getMName() + " " + this.getLName()
                + "\nDOB: " + this.getDob()
                + "\nGender: " + this.getGender()
                + "\nAge: " + this.getAge()
                + "\nEmail Address: " + this.getEmailAddress()
                + "\nPhone Number: " + this.getContactNo()
                + "\nAddress: " + this.getAddress()
                + "\nLast Visit: " + this.getMedicalHistory().getLastVisitDate()
                + "\n======================================================================\n";
    }

    @Override
    public int compareTo(Patient o) {
        return this.getLName().compareTo(o.getLName());
    }

    public static void main(String[] args) {
        LocalDate db = LocalDate.parse("2000-06-12");
        Patient p1 = new Patient("Samantha", "Shanice", "Thompson", "Female", db, "sthompson77@gmail.com", "876-561-6822", "21 Cherry Street, Kingston 8");
        System.out.println(p1.getPatientID());
        Patient p2 = new Patient("Sam", "Marcus", "Cook", "Male", db, "markscook@gmail.com", "876-501-6822", "23 Cherry Street, Kingston 8");
        System.out.println(p2.getPatientID());
    }

}
