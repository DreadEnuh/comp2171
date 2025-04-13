package database;

import patient_management.Patient;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private final String url = "jdbc:mysql://127.0.0.1:5150/login";
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

    public void savePatients(ArrayList<Patient> patients) {
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
            }
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:5150/pms",
                    "blairwcee",
                    "MakingherSQL@5");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PATIENTS");
            while (rs.next()) {
                System.out.println(rs.getString("pid"));
                System.out.println(rs.getString("email_address"));
            }
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }
    }

}
