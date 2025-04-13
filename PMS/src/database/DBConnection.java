package database;

import patient_management.Patient;
import user_management.Doctor;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private final String url = "jdbc:mysql://127.0.0.1:5150/pms";
    private final String username = "blairwcee";
    private final String password = "MakingherSQL@5";
    private Connection conn;

    public DBConnection () {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }
    }

    public boolean savePatients(ArrayList<Patient> patients) {
        String insertSQL = "INSERT INTO patients (pid, first_name, middle_name, last_name, gender, dob, email_address, phone_number, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            for (Patient p : patients) {
                stmt.setString(1, p.getPatientID());
                stmt.setString(2, p.getFName());
                stmt.setString(3, p.getMName());
                stmt.setString(4, p.getLName());
                stmt.setString(5, p.getGender());
                stmt.setDate(6, java.sql.Date.valueOf(p.getDob()));
                stmt.setString(7, p.getEmailAddress());
                stmt.setString(8, p.getContactNo());
                stmt.setString(9, p.getAddress());

                stmt.addBatch();
                return true;
            }
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }
        return false;
    }

    public boolean saveDoctors(ArrayList<Doctor> doctors) {
        String insertSQL = "INSERT INTO doctors (did, first_name, middle_initial, last_name, specialization) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            for (Doctor d : doctors) {
                stmt.setString(1, d.getID());
                stmt.setString(2, d.getFirstName());
                stmt.setString(3, d.getMiddleInitial());
                stmt.setString(4, d.getLastName());
                stmt.setString(5, d.getSpecialization());
                stmt.addBatch();
            }

            stmt.executeBatch();
            return true;
        }
        catch (SQLException se) {
            se.fillInStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();

        ArrayList<Doctor> doctorList = new ArrayList<>();

        // Sample doctors
        doctorList.add(new Doctor("Calvin", "R", "Klein", "Ophthalmology"));
        doctorList.add(new Doctor("Alice", "M", "Lee", "Pediatrics"));
        doctorList.add(new Doctor("John", "S", "Doe", "Cardiology"));
        doctorList.add(new Doctor("Emily", "T", "Clark", "Neurology"));
        doctorList.add(new Doctor("Samuel", "L", "King", "Orthopedics"));
        doctorList.add(new Doctor("Grace", "N", "Adams", "Dermatology"));
        doctorList.add(new Doctor("Brian", "P", "Stone", "ENT"));
        doctorList.add(new Doctor("Rachel", "B", "Green", "Gynaecology"));
        doctorList.add(new Doctor("Tom", "W", "Hardy", "Psychiatry"));
        doctorList.add(new Doctor("Julia", "Q", "Roberts", "Pulmonology"));
        doctorList.add(new Doctor("Nathan", "J", "Scott", "Oncology"));
        doctorList.add(new Doctor("Sophia", "L", "White", "Nephrology"));
        doctorList.add(new Doctor("Ethan", "A", "Hunt", "Urology"));
        doctorList.add(new Doctor("Olivia", "C", "Evans", "Gastroenterology"));
        doctorList.add(new Doctor("Victor", "D", "Young", "Hematology"));

        if (dbc.saveDoctors(doctorList)) {
            System.out.println("Saved Successfully");
        }

        else System.out.println("Fuckery");
    }

}
