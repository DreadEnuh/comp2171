package patient_management;

import database.DBConnection;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientService {
    private ArrayList<Patient> patients = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // Constructors
    public PatientService() {
        loadPatients();
    }

    // Getters
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    // Modifiers
    public void registerPatient() {
        System.out.println("Enter patient_management.Patient's First Name: ");
        String fName = scanner.nextLine().trim();

        System.out.println("Enter patient_management.Patient's Middle Name: ");
        String mName = scanner.nextLine().trim();

        System.out.println("Enter patient_management.Patient's Last Name: ");
        String lName = scanner.nextLine().trim();

        String dd, mm, yyyy;
        while (true) {
            System.out.println("Enter Date of Birth (DD MM YYYY): ");
            dd = scanner.next();
            mm = scanner.next();
            yyyy = scanner.next();
            if (isValidDOB(dd, mm, yyyy)) {
                break;
            }
            System.out.println("Invalid date format. Please try again.");
        }

        Patient newPatient = new Patient(fName, mName, lName, dd, mm, yyyy);
        scanner.nextLine();

        // Adding Medical Conditions
        System.out.println("Enter Medical Conditions (please type 'done' when finished):");
        while (true) {
            String condition = scanner.nextLine().trim();
            if (condition.equalsIgnoreCase("done")) break;
            newPatient.addCondition(condition);
        }
        addPatient(newPatient);
    }

    public void addPatient(Patient p) {this.patients.add(p);
    }

    public void deletePatient(Patient p) {
        this.patients.remove(p);
    }

    // Predicates
    public Boolean isNewPatient(String name) {
        return findPatientByName(name) == null;
    }

    private boolean isValidDOB(String dd, String mm, String yyyy) {
        try {
            int day = Integer.parseInt(dd);
            int month = Integer.parseInt(mm);
            int year = Integer.parseInt(yyyy);
            return (day > 0 && day <= 31) && (month > 0 && month <= 12) && (year > 1900 && year <= 2025);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Other Methods
    public Patient findPatientById(String pid) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getPatientID().equals(pid)) {
                retp = p;
            }
        }
        return retp;
    }

    public Patient findPatientByName(String name) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getFullName().equals(name)) {
                retp = p;
            }
        }
        return retp;
    }

    // Data handlers
    public void loadPatients() {
        this.patients = (ArrayList<patient_management.Patient>) database.DBConnection.loadPatientsFromFile();
    }

    public void savePatients() {
        DBConnection.savePatientsToFile(this.patients);
        System.out.println(this.patients.size());
    }
}
