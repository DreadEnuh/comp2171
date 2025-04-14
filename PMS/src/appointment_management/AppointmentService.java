package appointment_management;

import user_management.Doctor;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentService {
    private final ArrayList<Appointment> appointments;
    private final LocalDateTime systemTime;

    // Constructor
    public AppointmentService(DoctorService ds) {
        systemTime = LocalDateTime.now();
        appointments = new ArrayList<>();
        for (Doctor d: ds.getDoctors()) {
            appointments.addAll(d.getSchedule().getAppointments());
        }
    }

    // Getters
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public LocalDateTime getSystemTime() {
        return systemTime;
    }

    // Modifiers
    public boolean addAppointment(Appointment appointment, Doctor doctor) {
        return doctor.addAppointment(
                appointment.getDate(),
                appointment.getDuration(),
                appointment.getStartTime(),
                appointment.getPatientID(),
                doctor.getID());
    }

    // Data handlers
    public void loadAppointments() {

    }

    public static void saveAppointments() {

    }

    public static void main(String[] arg) {
        System.out.println("AppointmentService Class");
    }
}
