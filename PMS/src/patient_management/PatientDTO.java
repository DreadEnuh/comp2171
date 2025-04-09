package patient_management;

public class PatientDTO {
    private String fName;
    private String mName;
    private String lName;
    private String dateOfBirth;
    private String gender;
    private String contactNumber;
    private String email;
    private String address;

    // Constructors
    public PatientDTO() {
    }

    public PatientDTO(String fName, String mName, String lName, String dateOfBirth,
                      String gender, String contactNumber, String email, String address) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public String getFName() {
        return fName;
    }

    public String getMName() {
        return mName;
    }

    public String getLName() {
        return lName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}
