package database;

import patient_management.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=PMS"; // Change as needed
    private static final String USERNAME = "BLAIR-X1/willa";
    private static final String PASSWORD = "";

    public DBConnection() {

    }

    public boolean savePatient(Patient patient) {
        String insertQuery = "INSERT INTO dbo.Patients (patientID, fName, mName, lName, gender, dob, age, emailAddress, contactNo, address) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            stmt.setString(1, patient.getPatientID());
            stmt.setString(2, patient.getFName());
            stmt.setString(3, patient.getMName());
            stmt.setString(4, patient.getLName());
            stmt.setString(5, patient.getGender());
            stmt.setDate(6, java.sql.Date.valueOf(patient.getDob())); // Assuming getDob() returns LocalDate
            stmt.setInt(7, patient.getAge());
            stmt.setString(8, patient.getEmailAddress());
            stmt.setString(9, patient.getContactNo());
            stmt.setString(10, patient.getAddress());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        System.out.println(dbc.savePatient(new Patient("John", "Wilkes", "Booth", "Male", LocalDate.parse("1923-11-09"), "jwb00th@gmail.com", "610-232-1132", "1010 Cherry Street, Kingston")));
    }

}
