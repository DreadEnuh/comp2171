package user_management;

import appointment_management.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public class Doctor extends User {
    private String id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String fullName;
    private String specialization;
    private Schedule schedule;
    private Role role;
    private static int numDoctors = 1;

    // Constructors
    public Doctor() {
        super();
    }

    public Doctor(String firstName, String middleInitial, String lastName, String specialization) {
        super(firstName, middleInitial, lastName);
        String format = String.format("%03d", numDoctors);
        this.id =  "D" + specialization.charAt(0) + "-" + firstName.charAt(0) + middleInitial.charAt(0) + lastName.charAt(0) + String.format(format, numDoctors);
        this.specialization = specialization;
        this.schedule = new Schedule(this.id);
        this.fullName = firstName + " " + middleInitial + " " + lastName;
        role = new Role("Operator");
        numDoctors ++;
    }

    public Doctor(String firstName, String lastName, String specialization) {
        super(firstName, "X", lastName);
        this.specialization = specialization;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public static int getNumDoctors() {
        return numDoctors;
    }

    public Role getRole() {
        return role;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void viewSchedule() {
        System.out.println("user_management.Doctor: " + firstName + " " + lastName);
        System.out.println(schedule);
    }

    public void setSchedule(String doctorID, LocalDate date, int slotSize, LocalTime startTime, LocalTime endTime) {
        this.schedule = new Schedule(doctorID, date, slotSize, startTime, endTime);
    }

    public boolean addAppointment(LocalDate date, int duration, LocalTime start, String patientID, String doctorID) {
        return this.schedule.addAppointment(date, duration, start, patientID, doctorID);
    }


    public String toString() {
        return "user_management.Doctor ID: " + id +
               "\nName: " + getFullName() +
               "\nSpecialization: " + specialization;
    }

    public static void main(String[] args) {
        System.out.println("user_management.Doctor Class");
        Doctor d1 = new Doctor("Calvin", "R", "Klein", "Ophthalmology");
    }
}