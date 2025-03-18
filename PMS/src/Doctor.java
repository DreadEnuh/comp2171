public class Doctor {
    // Attributes
    private String id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String specialization;

    // Constructor with all fields
    public Doctor(String id, String firstName, String middleInitial, String lastName, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    // Constructor without middleInitial (optional)
    public Doctor(String id, String firstName, String lastName, String specialization) {
        this(id, firstName, "", lastName, specialization); // Call the main constructor with empty middleInitial
    }

    // Getters and Setters

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
    
    // Other methods
    // Method to get the full name of the doctor
    public String getFullName() {
        if (middleInitial.isEmpty()) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleInitial + ". " + lastName;
        }
    }

    // Override toString() for a readable representation of the Doctor object
    @Override
    public String toString() {
        return "Doctor ID: " + id +
               "\nName: " + getFullName() +
               "\nSpecialization: " + specialization;
    }
}