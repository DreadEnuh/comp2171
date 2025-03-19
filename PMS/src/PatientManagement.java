import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManagement {
    public static ArrayList<Patient> patients;
    private static final Scanner scanner = new Scanner(System.in);

    public PatientManagement() {
        patients = new ArrayList<>();
        loadPatients();
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void addPatient(Patient p) {patients.add(p);
    }

    public static void deletePatient(Patient p) {
        patients.remove(p);
    }

    public static Patient findPatientById(String pid) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getPatientID().equals(pid)) {
                retp = p;
            }
        }
        return retp;
    }

    public static Patient findPatientByName(String name) {
        Patient retp = null;
        for (Patient p:patients) {
            if (p.getFullName().equals(name)) {
                retp = p;
            }
        }
        return retp;
    }

    public static Boolean isNewPatient(String name) {
        return findPatientByName(name) == null;
    }

    public static Patient registerPatient() {
        System.out.println("Enter Patient's First Name: ");
        String fName = scanner.nextLine().trim();

        System.out.println("Enter Patient's Middle Name: ");
        String mName = scanner.nextLine().trim();

        System.out.println("Enter Patient's Last Name: ");
        String lName = scanner.nextLine().trim();

        String dd, mm, yyyy;
        while (true) {
            System.out.println("Enter Date of Birth (DD MM YYYY): ");
            dd = scanner.next();
            mm = scanner.next();
            yyyy = scanner.next();
            if (isValidDate(dd, mm, yyyy)) {
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
        return newPatient;
    }

    public static void loadPatients() {
        patients = (ArrayList<Patient>) DBConnection.loadPatientsFromFile();
    }

    public static void savePatients() {
        DBConnection.savePatientsToFile(patients);
    }

    private static boolean isValidDate(String dd, String mm, String yyyy) {
        try {
            int day = Integer.parseInt(dd);
            int month = Integer.parseInt(mm);
            int year = Integer.parseInt(yyyy);
            return (day > 0 && day <= 31) && (month > 0 && month <= 12) && (year > 1900 && year <= 2025);
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
