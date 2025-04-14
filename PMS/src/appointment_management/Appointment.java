package appointment_management;

import java.time.LocalTime;
import java.time.LocalDate;

public class Appointment {
    private LocalTime startTime;
    private int duration;

    // Constructors
    public Appointment() {}
    public Appointment(int duration, LocalTime startTime) {
        this.duration = duration;
        this.startTime = startTime;
    }

    // Getters
    public LocalTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    // Setters
    public void setStartTime(LocalTime newStartTime) {
        this.startTime = newStartTime;
    }

    public void setDuration(int newDuration) {
        this.duration = newDuration;
    }

    public LocalDate getDate() {
        return this.startTime.atDate(LocalDate.now()).toLocalDate();
    }

    public String getAppointmentSummary() {
        return "Appointment on " + getDate().toString() + " at " + getStartTime().toString() + " for " + getDuration() + " minutes";
    }
}
