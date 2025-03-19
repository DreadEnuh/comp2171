import java.time.LocalTime;
import java.util.List;

public class Doctor {
    // Attributes
    private String id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String fullName;
    private String specialization;
    private Schedule schedule;

    public Doctor() {}
    public Doctor(String id, String firstName, String middleInitial, String lastName, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.specialization = specialization;
        this.schedule = new Schedule();
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }

    public Doctor(String id, String firstName, String lastName, String specialization) {
        this(id, firstName, "", lastName, specialization);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean bookAppointment(LocalTime time) {
        return schedule.addAppointment(time);
    }

    public void viewSchedule() {
        System.out.println("Doctor: " + firstName + " " + lastName);
        schedule.displaySchedule();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(String date, int appointmentDuration, LocalTime startTime, LocalTime endTime) {
        this.schedule = new Schedule(date, appointmentDuration, startTime, endTime);
    }

    public List<LocalTime> getAvailableSlots() {
        return schedule.getAvailableSlots();
    }

    // Override toString() for a readable representation of the Doctor object
    @Override
    public String toString() {
        return "Doctor ID: " + id +
               "\nName: " + getFullName() +
               "\nSpecialization: " + specialization;
    }
}