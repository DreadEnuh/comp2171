package user_management;

import appointment_management.Schedule;

import java.time.LocalTime;

public class Doctor {
    private String id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String fullName;
    private String specialization;
    private Schedule schedule;

    // Constructors
    public Doctor() {}
    public Doctor(String firstName, String middleInitial, String lastName, String specialization) {
        this.id =  firstName.charAt(0) + lastName.charAt(1) - lastName.charAt(lastName.length() - 1) + "0" + firstName.charAt(0) + middleInitial.charAt(0) + lastName.charAt(0);
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.specialization = specialization;
        this.schedule = new Schedule();
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
    public Doctor(String firstName, String lastName, String specialization) {
        this(firstName, "X", lastName, specialization);
    }

    // Getters
    public String getId() {
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

    public void setSchedule(String date, int slotSize, LocalTime startTime, LocalTime endTime) {
        this.schedule = new Schedule(date, slotSize, startTime, endTime);
    }

    public boolean addAppointment(int duration, LocalTime start) {
        return this.schedule.makeAppointment(duration, start);
    }


    public String toString() {
        return "user_management.Doctor ID: " + id +
               "\nName: " + getFullName() +
               "\nSpecialization: " + specialization;
    }

    public static void main(String[] args) {
        System.out.println("user_management.Doctor Class");
    }
}