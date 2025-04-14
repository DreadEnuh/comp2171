package database;

import appointment_management.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AppointmentDatabase {
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    public AppointmentDatabase () {}

    // Getters

    public ArrayList<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentByID(String aid) {
        Appointment reta = null;
        for (Appointment a:appointments) {
            if (a.getAppointmentID().equals(aid)) {
                reta = a;
            }
        }
        return reta;
    }

    public Appointment getAppointmentByDateTime(LocalDate date, LocalTime time) {
        Appointment reta = null;
        for (Appointment a:appointments) {
            if ((a.getDate().equals(date)) && (a.getStartTime().equals(time))) {
                reta = a;
            }
        }
        return reta;
    }

    // Modifiers

    public boolean addAppointment(Appointment a) {
        this.appointments.add(a);
        return true;
    }

    public void deleteAppointment(Appointment a) {
        this.appointments.remove(a);
    }

    public boolean updateAppointment(Appointment a) {
        Appointment oa = getAppointmentByID(a.getAppointmentID());
        deleteAppointment(oa);
        addAppointment(a);
        return true;
    }

    // Predicates

    public boolean AppointmentIDExists(String did) {
        return (getAppointmentByID(did) != null);
    }

    public int countTotalAppointments() {
        return appointments.size();
    }
}
