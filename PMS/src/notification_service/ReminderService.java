package notification_service;

import appointment_management.Appointment;
import database.DBConnection;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.*;
import com.sun.net.httpserver.HttpExchange;
import patient_management.Patient;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReminderService {
    private final Notification notification;

    public ReminderService(Notification notification) {
        this.notification = notification;
    }
    //public ReminderService(Notification notification) {
    //    this.notification = notification;
    //}

    public void checkAndSendReminders() {
        try {
            // 1. Get all upcoming appointments
            List<Appointment> appointments = getUpcomingAppointments();
            
            // 2. Process each appointment
            for (Appointment appointment : appointments) {
                Patient patient = getPatientById(appointment.getPatientID());
                if (patient != null) {
                    sendReminder(appointment, patient);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private List<Appointment> getUpcomingAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT appointment_id, date, duration, start_time, patient_id, doctor_id " +
                       "FROM appointments " +
                       "WHERE date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 10 DAY)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                appointments.add(new Appointment(
                    rs.getString("appointment_id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getInt("duration"),
                    rs.getTime("start_time").toLocalTime(),
                    rs.getString("patient_id"),
                    rs.getString("doctor_id")
                ));
            }
        }
        return appointments;
    }

    private Patient getPatientById(String patientId) throws SQLException {
        String query = "SELECT pid, first_name, middle_name, last_name, gender, dob, " +
                      "email_address, phone_number, address " +
                      "FROM patients WHERE pid = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Patient(
                    rs.getString("pid"),
                    rs.getString("first_name"),
                    rs.getString("middle_name"),
                    rs.getString("last_name"),
                    rs.getString("gender"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("email_address"),
                    rs.getString("phone_number"),
                    rs.getString("address")
                );
            }
        }
        return null;
    }

    private Connection getConnection() throws SQLException {
        DBConnection.setUrl("pms");
        return DriverManager.getConnection(
            DBConnection.getUrl(),
            DBConnection.getUsername(),
            DBConnection.getPassword()
        );
    }

    public void sendReminder(Appointment appointment, Patient patient) {
        String message = String.format(
            "Appointment Reminder\n\n" +
            "Patient: %s %s\n" +
            "Date: %s\n" +
            "Time: %s\n" +
            "Duration: %d minutes\n\n" +
            "Please arrive 15 minutes early.",
            patient.getFName(),
            patient.getLName(),
            appointment.getAppointmentDate(),
            appointment.getStartTime(),
            appointment.getDuration()
        );

        notification.sendNotification(patient.getContactNo(), message);
        
        if (patient.getEmailAddress() != null && !patient.getEmailAddress().isEmpty()) {
            notification.sendNotification(patient.getEmailAddress(), message);
        }
    }

    //private String generateReminderMessage(Appointment appointment, Patient patient) {
    //    long daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), appointment.getAppointmentDate());
    //    return String.format(
    //        "Dear %s %s,\nYour appointment is scheduled for %s at %s.\n%s",
    //        patient.getFName(),
    //        patient.getLName(),
    //        appointment.getAppointmentDate(),
    //        appointment.getStartTime(),
    //        daysUntil <= 1 ? "Please confirm your attendance." : 
    //                        "You have " + daysUntil + " days until your appointment."
    //    );
    //}

    //public String getReminderMessage(Appointment appointment) {
    //    return generateReminderMessage(appointment);
    //}
}
