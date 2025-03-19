import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String FILE_NAME = "patients.txt";

    // Method to save patients to file
    public static void savePatientsToFile(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Patient p : patients) {
                writer.write("Patient ID: " + p.getPatientID());
                writer.newLine();
                writer.write("Name: " + p.getFName() + " " + p.getMName() + " " + p.getLName());
                writer.newLine();
                writer.write("Date of Birth: " + p.getDob());
                writer.newLine();

                // Save medical conditions
                writer.write("Medical Conditions:");
                writer.newLine();
                for (String condition : p.getConditions()) {
                    writer.write("- " + condition);
                    writer.newLine();
                }

                // Save visit history
                writer.write("Visit History:");
                writer.newLine();
                for (String visit : p.getVisitsInfo()) {
                    writer.write(visit);
                    writer.newLine();
                    writer.write("--------------------------------------------------");
                    writer.newLine();
                }

                writer.write("Total Visits: " + p.getNumVisits());
                writer.newLine();
                writer.write("============================================================================");
                writer.newLine();
            }
            System.out.println("Patient data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving patient data: " + e.getMessage());
        }
    }

    // Method to load and display patient data from file
    public static ArrayList<Patient> loadPatientsFromFile() {
        ArrayList<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            Patient currentPatient = null;
            MedicalHistory currentMedicalHistory = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Patient ID: ")) {
                    String id = line.substring(12);
                    currentPatient = new Patient();
                    currentMedicalHistory = new MedicalHistory();
                    currentPatient.setPatientID(id);
                } else if (line.startsWith("Name: ")) {
                    String[] nameParts = line.substring(6).split(" ");
                    assert currentPatient != null;
                    currentPatient.setFName(nameParts[0]);
                    currentPatient.setMName(nameParts[1]);
                    currentPatient.setLName(nameParts[2]);
                } else if (line.startsWith("Date of Birth: ")) {
                    String dateStr = line.substring(15);
                    assert currentPatient != null;
                    currentPatient.setDob(LocalDate.parse(dateStr));
                } else if (line.startsWith("- ")) {
                    assert currentMedicalHistory != null;
                    currentMedicalHistory.addCondition(line.substring(2));
                } else if (line.startsWith("Visit number: ")) {
                    assert currentMedicalHistory != null;
                    currentMedicalHistory.getVisitsInfo().add(line);
                } else if (line.startsWith("Total Visits: ")) {
                    assert currentMedicalHistory != null;
                    currentMedicalHistory.setNumVisits(Integer.parseInt(line.substring(14)));
                } else if (line.startsWith("============================================================================")) {
                    if (currentPatient != null) {
                        currentPatient.setMedHistory(currentMedicalHistory);
                        patients.add(currentPatient);
                    }
                }
            }
            System.out.println("Patient data loaded successfully!");
        } catch (IOException e) {
            System.err.println("Error loading patient data: " + e.getMessage());
        }
        return patients;
    }
}
