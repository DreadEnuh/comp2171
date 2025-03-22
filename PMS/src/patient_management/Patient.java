package patient_management;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient implements Comparable<Patient>{
    private String patientID, fName, mName, lName;
    private MedicalHistory medHistory;
    private static int patientNumber;
    private LocalDate dob;

    public Patient(){}
    public Patient(String fName, String mName, String lName, String dd, String mm, String yyyy) {
        this.fName = fName.toUpperCase();
        this.mName = mName.toUpperCase();
        this.lName = lName.toUpperCase();
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

    public ArrayList<String> getConditions() {
        return medHistory.getConditions();
    }

    public ArrayList<String> getVisitsInfo() {
        return medHistory.getVisitsInfo();
    }

    public int getNumVisits() {
        return medHistory.getNumVisits();
    }

    public void addCondition(String condition) {
        this.medHistory.addCondition(condition);
    }

    public int getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }

    public String getFullName() {
        return fName + " " + mName + " " + lName;
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

    public void setPatientID(String pid) {
        this.patientID = pid;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public static void setPatientNumber(int pNum) {
        patientNumber = pNum;
    }

    public String toString() {
        return "\n======================================================================\n"
                + "ID: " + this.getPatientID()
                + "\nName: " + this.getFName() + " " + this.getMName() + " " + this.getLName()
                + "\nDOB: " + this.getDob()
                + "\nAge: " + this.getAge()
                + this.getMedicalHistory()
                + "\n======================================================================\n";
    }

    @Override
    public int compareTo(Patient o) {
        return this.getLName().compareTo(o.getLName());
    }

    public static void main(String[] args) {
    }

}
