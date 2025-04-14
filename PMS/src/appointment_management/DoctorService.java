package appointment_management;

import user_management.Doctor;

import java.util.ArrayList;

public class DoctorService {

    // Constructor
    public DoctorService() {}

    // Other Methods
    public static Doctor findDoctorByID(ArrayList<Doctor> doctors, String id) {
        Doctor retdoc = null;
        for (Doctor d:doctors) {
            if (d.getID().equals(id)) {
                retdoc = d;
            }
        }
        return retdoc;
    }

    public static Doctor findDoctorByName(ArrayList<Doctor> doctors, String name) {
        Doctor retdoc = null;

        for (Doctor d: doctors) {
            if (name.equals(d.getFullName())){
                retdoc = d;
            }
        }
        return retdoc;
    }

    public static void main(String[] args) {
        System.out.println("DoctorService Class");
    }
}
