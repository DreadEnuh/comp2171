package database;

import patient_management.Patient;

import java.util.ArrayList;

public class PatientDatabase {
    private final ArrayList<Patient> patients = new ArrayList<>();

    public PatientDatabase() {}

    // Getters

    public ArrayList<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientByID(String pid) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getPatientID().equals(pid)) {
                retp = p;
            }
        }
        return retp;
    }

    public Patient getPatientByName(String name) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getFullName().equals(name)) {
                retp = p;
            }
        }
        return retp;
    }

    // Modifiers

    public boolean addPatient(Patient p) {
        this.patients.add(p);
        return true;
    }

    public void deletePatient(Patient p) {
        this.patients.remove(p);
    }

    public boolean updatePatient(Patient p) {
        Patient op = getPatientByID(p.getPatientID());
        deletePatient(op);
        addPatient(p);
        return true;
    }

    // Predicates

    public boolean patientIDExists(String pid) {
        return (getPatientByID(pid) != null);
    }

    public Boolean patientNameExists(String name) {
        return getPatientByName(name) == null;
    }

    public int countTotalPatients() {
        return patients.size();
    }
}
