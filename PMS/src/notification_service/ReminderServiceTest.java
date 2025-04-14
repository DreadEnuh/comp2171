package notification_service;

import appointment_management.Appointment;
import patient_management.Patient;
import user_management.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReminderServiceTest {
    public void testSendReminder() {
        // Create a patient object
       Patient patient = new Patient("John", "MiddleName", "Doe", "Male", LocalDate.of(1990, 1, 1), "willandoblair07@gmail.com", "8765677430", "123 Main St");
       String patientSummary = patient.getPatientSummary();

       // Create a doctor object
        Doctor doctor = new Doctor("Janet", "C", "Chang", "Urology");

        // Create an appointment object
        Appointment appointment = new Appointment(LocalDate.parse("2025-04-16"), 60, LocalTime.parse("09:30:00"), patient.getPatientID(), doctor.getID());
        String appointmentSummary = appointment.getAppointmentSummary();

        // Create a notification object
        Notification notification = new Notification();

        // Create a reminder service object
        ReminderService reminderService = new ReminderService(notification);

        // Call the sendReminder() method
        reminderService.sendReminder(appointment, patient);

    }

    public static void main(String[] args) {
        ReminderServiceTest test = new ReminderServiceTest();
        test.testSendReminder();
    }
}
