package appointment_management;

import database.DoctorDatabase;
import user_management.Doctor;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentService {
    private final ArrayList<Appointment> appointments;
    private final LocalDateTime systemTime;

    // Constructor
    public AppointmentService(DoctorDatabase ddb) {
        systemTime = LocalDateTime.now();
        appointments = new ArrayList<>();
        for (Doctor d: ddb.getAllDoctors()) {
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
        Schedule thisSchedule = doctor.getSchedule();
        if (thisSchedule.addAppointment(appointment.getDate(),
                appointment.getDuration(),
                appointment.getStartTime(),
                appointment.getPatientID(),
                doctor.getID())) {
            doctor.setSchedule(thisSchedule);
            return true;
        }
        return false;
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
