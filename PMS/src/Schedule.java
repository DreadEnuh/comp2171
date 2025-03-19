import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String date;  // Format: YYYY-MM-DD
    private int appointmentDuration; // in minutes
    private List<LocalTime> appointments;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule() {}

    public Schedule(String date, int appointmentDuration, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.appointmentDuration = appointmentDuration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointments = new ArrayList<>();
    }

    public boolean addAppointment(LocalTime time) {
        if (time.isBefore(startTime) || time.plusMinutes(appointmentDuration).isAfter(endTime)) {
            System.out.println("Invalid appointment time: " + time);
            return false;
        }

        if (appointments.contains(time)) {
            System.out.println("Time slot already booked: " + time);
            return false;
        }

        appointments.add(time);
        System.out.println("Appointment scheduled at: " + time);
        return true;
    }

    public List<LocalTime> getAvailableSlots() {
        List<LocalTime> availableSlots = new ArrayList<>();
        LocalTime time = startTime;
        while (!time.plusMinutes(appointmentDuration).isAfter(endTime)) {
            if (!appointments.contains(time)) {
                availableSlots.add(time);
            }
            time = time.plusMinutes(appointmentDuration);
        }
        return availableSlots;
    }

    public void displaySchedule() {
        System.out.println("Schedule for " + date);
        System.out.println("Appointments:");
        for (LocalTime time : appointments) {
            System.out.println("- " + time);
        }
    }

    public String getDate() {
        return this.date;
    }

}
