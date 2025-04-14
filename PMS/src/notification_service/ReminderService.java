package notification_service;

import appointment_management.Appointment;
import com.sun.net.httpserver.HttpExchange;
import patient_management.Patient;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.transform.Result;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class ReminderService {
    private final Notification notification;

    public ReminderService() {
        this.notification = new Notification();
    }
    public ReminderService(Notification notification) {
        this.notification = notification;
    }

    public void sendReminder(Appointment appointment,  Patient patient) {
        // Step 1: Retrieve patient's contact and appointment details
        String patientSummary = patient.getPatientSummary();
        String appointmentSummary = appointment.getAppointmentSummary();

        // Step 2: Generate a reminder message
        String reminderMessage = generateReminderMessage(appointment);

        // Step 3: Send the reminder to the patient
        notification.sendNotification(patient.getContactNo(), reminderMessage);
    }

    private String generateReminderMessage(Appointment appointment) {
        // Generate a reminder message based on the appointment details
        LocalDate appointmentDate = appointment.getDate();
        long daysUntilAppointment = ChronoUnit.DAYS.between(LocalDate.now(), appointmentDate);

        if (daysUntilAppointment <= 10) {
            return "Reminder: Your appointment is scheduled for " + appointmentDate + ". Please confirm your attendance.\n";
        } else {
            return "Reminder: Your appointment is scheduled for " + appointmentDate + ". You have " + daysUntilAppointment + " days left.\n";
        }
    }

    public String getReminderMessage(Appointment appointment) {
        return generateReminderMessage(appointment);
    }

    private void sendEmail(String to, String subject, String body) {
        // Set up email properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Set up email authentication
        Session session = Session.getInstance(props, new Authenticator() {
            public Result authenticate(HttpExchange exch) {
                return null;
            }

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("semai7119@gmail.com", "Itsabadhabit");
            }
        });

        try {
            // Create a new email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("semai7119@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
