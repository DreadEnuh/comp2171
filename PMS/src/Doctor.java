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

    //Getters
}