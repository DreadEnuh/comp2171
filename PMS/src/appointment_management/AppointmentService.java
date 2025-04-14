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

    public Appointment getAppointmentByPid(String pid) {
        Appointment retap = null;

        for (Appointment a:appointments) {
            if (a.getPatientID().equals(pid)) {
                retap = a;
            }
        }
        return retap;
    }

    public Appointment getAppointmentById(String aid) {
        Appointment retap = null;

        for (Appointment a:appointments) {
            if (a.getPatientID().equals(aid)) {
                retap = a;
            }
        }
        return retap;
    }



    public static void main(String[] arg) {
        System.out.println("AppointmentService Class");
    }
}
