package database;

import user_management.Doctor;

import java.util.ArrayList;

public class DoctorDatabase {
    private final ArrayList<Doctor> doctors = new ArrayList<>();

    public DoctorDatabase () {}

    // Getters

    public ArrayList<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorByID(String pid) {
        Doctor retd = null;
        for (Doctor d:doctors) {
            if (d.getID().equals(pid)) {
                retd = d;
            }
        }
        return retd;
    }

    public Doctor getDoctorByName(String name) {
        Doctor retd = null;
        for (Doctor d:doctors) {
            if (d.getFullName().equals(name)) {
                retd = d;
            }
        }
        return retd;
    }

    // Modifiers

    public boolean addDoctor(Doctor d) {
        this.doctors.add(d);
        return true;
    }

    public void deleteDoctor(Doctor d) {
        this.doctors.remove(d);
    }

    public boolean updateDoctor(Doctor d) {
        Doctor od = getDoctorByID(d.getID());
        deleteDoctor(od);
        addDoctor(d);
        return true;
    }

    // Predicates

    public boolean DoctorIDExists(String did) {
        return (getDoctorByID(did) != null);
    }

    public Boolean DoctorNameExists(String name) {
        return getDoctorByName(name) == null;
    }

    public int countTotalDoctors() {
        return doctors.size();
    }
}
