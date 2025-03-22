package appointment_management;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
    private String date;
    private int slotSize;
    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<LocalTime> filledSlots;
    private ArrayList<Appointment> appointments;
    private DateTimeFormatter tFormatter;

    // Constructors
    public Schedule() {}

    public Schedule(String date, int slotSize, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.slotSize = slotSize;
        this.startTime = startTime;
        this.endTime = endTime;
        this.filledSlots = new ArrayList<>();
        this.appointments = new ArrayList<>();
        tFormatter = DateTimeFormatter.ISO_TIME;
        tFormatter = DateTimeFormatter.ofPattern("HH:mm");
    }

    // Getters
    public String getDate() {
        return this.date;
    }

    public int getSlotSize() {
        return slotSize;
    }

    public ArrayList<LocalTime> getAvailableSlots() {
        ArrayList<LocalTime> availableSlots = new ArrayList<>();
        LocalTime time = startTime;
        while (!time.plusMinutes(slotSize).isAfter(endTime)) {
            if (!filledSlots.contains(time)) {
                availableSlots.add(time);
            }
            time = time.plusMinutes(slotSize);
        }
        return availableSlots;
    }

    public ArrayList<LocalTime> getFilledSlots() {
        return filledSlots;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public int getNumAppointments() {
        return this.appointments.size();
    }

    // Modifiers
    public boolean makeAppointment(int duration, LocalTime start) {
        if (start.isBefore(startTime) || start.plusMinutes(duration).isAfter(endTime)) {
            System.out.println("Invalid appointment time: " + start);
            return false;
        }

        if (filledSlots.contains(start)) {
            System.out.println("Time slot already booked: " + start);
            return false;
        }

        appointments.add(new Appointment(duration, start));
        filledSlots.add(start);
        System.out.println("Appointment scheduled at: " + start);
        return true;
    }

    // Other Methods
    public String toString() {
        StringBuilder retString = new StringBuilder(" ");
        retString.append("appointment_management.Schedule for ").append(date);
        retString.append("\nAppointments:");
        for (Appointment a : appointments) {
            retString.append("- ").append(a.getStartTime().format(tFormatter));
        }
        return retString.toString();
    }

    public static void main(String[] args) {
        System.out.println("Schedule class");
    }
}
