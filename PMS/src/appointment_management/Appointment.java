package appointment_management;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String appointmentID, patientID, doctorID;
    private LocalTime startTime;
    private LocalDate date;
    private int duration;
    private static int numAppointments = 1;

    // Constructors
    public Appointment() {}
    public Appointment(LocalDate date, int duration, LocalTime startTime, String patientID, String doctorID) {
        this.date = date;
        this.duration = duration;
        this.startTime = startTime;
        this.patientID = patientID;
        this.doctorID = doctorID;
        String format = String.format("%04d", numAppointments);
        this.appointmentID = "A13" + String.format(format, numAppointments);
        numAppointments ++;
    }

    // Getters
    public LocalDate getAppointmentDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public static int getNumAppointments() {
        return numAppointments;
    }

    // Setters

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime newStartTime) {
        this.startTime = newStartTime;
    }

    public void setDuration(int newDuration) {
        this.duration = newDuration;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public LocalDate getDate() {
        return this.startTime.atDate(LocalDate.now()).toLocalDate();
    }

    public String getAppointmentSummary() {
        return "Appointment on " + getDate().toString() + " at " + getStartTime().toString() + " for " + getDuration() + " minutes";
    }
}
