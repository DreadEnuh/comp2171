package appointment_management;

import user_management.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private static final ArrayList<Doctor> doctors = new ArrayList<>();

    // Constructor
    public DoctorService() {}

    // Getters
    public static List<Doctor> getDoctors() {
        return (ArrayList<Doctor>) doctors;
    }

    // Modifiers


    // Other Methods
    public static Doctor findDoctorByID(String id) {
        Doctor retdoc = null;
        for (Doctor d:doctors) {
            if (d.getId().equals(id)) {
                retdoc = d;
            }
        }
        return retdoc;
    }

    public static Doctor findDoctorByName(String name) {
        Doctor retdoc = null;

        for (Doctor d: doctors) {
            if (name.equals(d.getFullName())){
                retdoc = d;
            }
        }
        return retdoc;
    }

    // Data handlers
    public static void loadDoctors() {

    }

    public static void saveDoctors() {

    }

    public static void main(String[] args) {
        System.out.println("DoctorService Class");
    }
}
