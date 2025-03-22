package database;

import appointment_management.Appointment;
import patient_management.MedicalHistory;
import patient_management.Patient;
import user_management.Doctor;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String DOCTORS_FILE = "docs.txt";
    private static final String APPOINTMENTS_FILE = "apps.txt";


    public static void savePatientsToFile(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            for (Patient p : patients) {
                writer.write("patient_management.Patient ID: " + p.getPatientID());
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
                writer.write("======================================================================");
                writer.newLine();
            }
            System.out.println("patient_management.Patient data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving patient data: " + e.getMessage());
        }
    }

    public static List<Patient> loadPatientsFromFile() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            String line;
            Patient currentPatient = null;
            MedicalHistory currentMedicalHistory = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("patient_management.Patient ID: ")) {
                    String id = line.substring(12);
                    currentPatient = new Patient(); // Create new patient instance
                    currentMedicalHistory = new MedicalHistory();
                    currentPatient.setPatientID(id);
                    int pNum = Integer.parseInt(id.substring(3)) + 1;
                    Patient.setPatientNumber(pNum);
                } else if (line.startsWith("Name: ")) {
                    String[] nameParts = line.substring(6).split(" ");
                    currentPatient.setFName(nameParts[0]);
                    currentPatient.setMName(nameParts[1]);
                    currentPatient.setLName(nameParts[2]);
                } else if (line.startsWith("Date of Birth: ")) {
                    String dateStr = line.substring(15);
                    currentPatient.setDob(LocalDate.parse(dateStr));
                } else if (line.startsWith("- ")) {
                    currentMedicalHistory.addCondition(line.substring(2));
                } else if (line.startsWith("Visit number: ")) {
                    currentMedicalHistory.getVisitsInfo().add(line);
                } else if (line.startsWith("Total Visits: ")) {
                    currentMedicalHistory.setNumVisits(Integer.parseInt(line.substring(14)));
                } else if (line.startsWith("======================================================================")) {
                    if (currentPatient != null) {
                        currentPatient.setMedHistory(currentMedicalHistory);
                        patients.add(currentPatient);
                    }
                }
            }
            System.out.println("patient_management.Patient data loaded successfully!");
        } catch (IOException e) {
            System.err.println("Error loading patient data: " + e.getMessage());
        }
        return patients;
    }

    public static void saveDoctors(List<Doctor> doctors, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getFullName() + "," + doctor.getSchedule().getDate() + "\n");
            }
            System.out.println("Doctors saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving doctors: " + e.getMessage());
        }
    }

    public static List<Doctor> loadDoctors(String filename) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
//                    user_management.Doctor thisDoctor = new user_management.Doctor(parts[0], parts[1], parts[2], parts[3], parts[4]);
//                    thisDoctor.setSchedule(parts[0], 30, LocalTime.of(9, 0), LocalTime.of(17, 0));
                }
            }
            System.out.println("Doctors loaded successfully!");
        } catch (IOException e) {
            System.err.println("Error loading doctors: " + e.getMessage());
        }
        return doctors;
    }

    public static void saveAppointments() {

    }

    public static List<Appointment> loadAppointments() {

        return new ArrayList<>();
    }
}
