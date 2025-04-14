package appointment_management;

import user_management.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private final ArrayList<Doctor> doctors = new ArrayList<>();

    // Constructor
    public DoctorService() {}

    // Getters
    public List<Doctor> getDoctors() {
        return (ArrayList<Doctor>) doctors;
    }

    // Modifiers


    // Other Methods
    public Doctor findDoctorByID(String id) {
        Doctor retdoc = null;
        for (Doctor d:doctors) {
            if (d.getID().equals(id)) {
                retdoc = d;
            }
        }
        return retdoc;
    }

    public Doctor findDoctorByName(String name) {
        Doctor retdoc = null;

        for (Doctor d: doctors) {
            if (name.equals(d.getFullName())){
                retdoc = d;
            }
        }
        return retdoc;
    }

    public Doctor findDoctorByUsername(String username) {
        Doctor retdoc = null;

        for (Doctor d: doctors) {
            if (username.equals(d.getUserName())){
                retdoc = d;
            }
        }
        return retdoc;
    }

    public static void main(String[] args) {
        System.out.println("DoctorService Class");
    }
}
