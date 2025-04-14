package appointment_management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
    private String doctorID;
    private LocalDate date;
    private int slotSize;
    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<LocalTime> filledSlots;
    private ArrayList<Appointment> appointments;
    private DateTimeFormatter tFormatter;

    // Constructors
    public Schedule(String doctorID) {}

    public Schedule(String doctorID, LocalDate date, int slotSize, LocalTime startTime, LocalTime endTime) {
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
    public LocalDate getDate() {
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

    // Setters

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSlotSize(int slotSize) {
        this.slotSize = slotSize;
    }

    // Modifiers
    public boolean addAppointment(LocalDate date, int duration, LocalTime start, String patientID, String doctorID) {
        if (start.isBefore(startTime) || start.plusMinutes(duration).isAfter(endTime)) {
            System.out.println("Invalid appointment time: " + start);
            return false;
        }

        if (filledSlots.contains(start)) {
            System.out.println("Time slot already booked: " + start);
            return false;
        }

        appointments.add(new Appointment(date, duration, start, patientID, doctorID));
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

    public boolean removeAppointment(String appointmentID) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appt = appointments.get(i);
            if (appt.getAppointmentID().equals(appointmentID)) {
                filledSlots.remove(appt.getStartTime());
                appointments.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean rescheduleAppointment(String appointmentID, LocalDate newDate, LocalTime newStartTime, int newDuration) {
        for (Appointment appt : appointments) {
            if (appt.getAppointmentID().equals(appointmentID)) {
                if (newStartTime.isBefore(startTime) || newStartTime.plusMinutes(newDuration).isAfter(endTime)) {
                    return false;
                }
                if (filledSlots.contains(newStartTime)) {
                    return false;
                }
                // Free the old slot and update the appointment
                filledSlots.remove(appt.getStartTime());
                filledSlots.add(newStartTime);
                appt.setStartTime(newStartTime);
                appt.setDuration(newDuration);
                appt.setDate(newDate);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Schedule class");
    }
}
