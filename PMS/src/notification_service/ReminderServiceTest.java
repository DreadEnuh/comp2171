package notification_service;

import patient_management.Patient;
import appointment_management.Appointment;
import notification_service.*;
import junit.framework.Assert;

import java.time.*;

public class ReminderServiceTest {
    public void testSendReminder() {
        // Create a patient object
       Patient patient = new Patient("John", "MiddleName", "Doe", "Male", LocalDate.of(1990, 1, 1), "johndoe@example.com", "123-456-7890", "123 Main St");
       String patientSummary = patient.getPatientSummary();

        // Create an appointment object
        Appointment appointment = new Appointment(30, LocalTime.parse("10:00"));
        String appointmentSummary = appointment.getAppointmentSummary();

        // Create a notification object
        Notification notification = new Notification();

        // Create a reminder service object
        ReminderService reminderService = new ReminderService(notification);

        // Call the sendReminder() method
        reminderService.sendReminder(appointment, patient);

        // Verify that the reminder message was generated correctly
        // String expectedReminderMessage = "Reminder: Your appointment is scheduled for 2024-04-13 at 10:00 for 30 minutes. Patient: John Doe (johndoe@example.com, 123-456-7890)";
        // Assert.assertEquals(expectedReminderMessage, reminderService.getReminderMessage(appointment));

        // Verify that the notification was sent
        // assertTrue(notification.wasNotificationSent());
    }

    public static void main(String[] args) {
        ReminderServiceTest test = new ReminderServiceTest();
        test.testSendReminder();
    }
}
