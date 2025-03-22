package appointment_management;

import user_management.Doctor;

import java.util.ArrayList;

public class AppointmentService {
    private static ArrayList<Appointment> appointments;

    // Constructor
    public AppointmentService() {
        appointments = new ArrayList<>();
        for (Doctor d: DoctorService.getDoctors()) {
            appointments.addAll(d.getSchedule().getAppointments());
        }
    }

    // Getters
    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // Modifiers
    public static boolean addAppointment(Appointment appointment, Doctor doctor) {
        return doctor.addAppointment(appointment.getDuration(), appointment.getStartTime());
    }

    public static void main(String[] arg) {
        System.out.println("AppointmentService Class");
    }
}
