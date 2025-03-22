package ui;

import appointment_management.Appointment;
import appointment_management.DoctorService;
import patient_management.Patient;
import patient_management.PatientService;
import user_management.Doctor;

import java.time.LocalTime;
import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void driver() {
        PatientService pms = new PatientService();
        mainMenu(pms);
    }

    public static void mainMenu(PatientService pms) {
        while (true) {
            System.out.println("\n=== PATIENT MANAGEMENT SYSTEM ===");
            System.out.println("R - Register patient_management.Patient");
            System.out.println("S - appointment_management.Schedule appointment_management.Appointment");
            System.out.println("V - View user_management.Doctor appointment_management.Schedule");
            System.out.println("P- View Patients");
            System.out.println("E - Exit");
            System.out.print("What would you like to do today: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "R":
                    pms.registerPatient();
                    System.out.println("patient_management.Patient Registered: " + pms.getPatients().getLast().getPatientID());
                    break;


                case "S":
                    System.out.print("Enter the name/ID of the desired doctor: ");
                    String search = scanner.nextLine().trim().toUpperCase();
                    Doctor desDoctor = null;

                    if (search.length() == 6) {
                        desDoctor = DoctorService.findDoctorByID(search);
                    } else if (search.isEmpty()) {
                        System.out.println("Empty Search! Please try again.");
                    } else {
                        desDoctor = DoctorService.findDoctorByName(search);
                    }

                    if (desDoctor == null) {
                        System.out.println("user_management.Doctor not found!");
                    }

                    System.out.println("How long do you want your appointment to be in minutes: ");
                    String appl = scanner.nextLine().trim();

                    System.out.println("What time would you like to start: ");
                    String appt = scanner.nextLine().trim();

                    int desTime = Integer.parseInt(appl);
                    LocalTime time = LocalTime.parse(appt);

                    assert desDoctor != null;
                    appointment_management.AppointmentService.addAppointment(new Appointment(desTime, time), desDoctor);
                    break;

                case "V":
                    System.out.println("Not yet implemented");
//                    AppointmentManagement.viewDoctorSchedule();
                    break;

                case "E":
                    System.out.println("Exiting the system. Goodbye!");
                    pms.savePatients();
                    System.exit(0);
                    break;

                case "P":
                    for (Patient p:pms.getPatients())
                        System.out.println(p);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        driver();
    }
}
