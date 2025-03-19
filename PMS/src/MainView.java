import java.util.Scanner;
public class MainView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void driver() {
        new PatientManagement();
        new AppointmentManagement();
        mainMenu();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\n=== PATIENT MANAGEMENT SYSTEM ===");
            System.out.println("R - Register Patient");
            System.out.println("S - Schedule Appointment");
            System.out.println("V - View Doctor Schedule");
            System.out.println("E - Exit");
            System.out.print("What would you like to do today: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "R":
                    Patient newPatient = PatientManagement.registerPatient();
                    System.out.println("Patient Registered: " + newPatient.getPatientID());
                    break;

                case "S":
                    AppointmentManagement.scheduleAppointment();
                    break;

                case "V":
                    AppointmentManagement.viewDoctorSchedule();
                    break;

                case "E":
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        driver();
    }
}
