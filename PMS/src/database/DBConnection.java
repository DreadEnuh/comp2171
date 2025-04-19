package database;

import appointment_management.Appointment;
import patient_management.MedicalHistory;
import patient_management.Patient;
import user_management.Doctor;
import user_management.Receptionist;
import user_management.User;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;

public class DBConnection {
    private static String url = "jdbc:mysql://127.0.0.1:5150/pms";
    private static final String username = "blairwcee";
    private static final String password = "MakingherSQL@5";

    public DBConnection () {
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setSchema(String schema) {
        url = url.substring(0, url.lastIndexOf("/") + 1);
        url = url + schema;
    }

    // Fix save method to save conditions in a string that can be deconstructed methodically
    public static boolean savePatients(ArrayList<Patient> patients) {
        setSchema("pms");
        String insertSQL = "REPLACE INTO patients (pid, first_name, middle_name, last_name, gender, dob, email_address, phone_number, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
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

    public static ArrayList<Patient> loadPatients() {
        setSchema("pms");
        ArrayList<Patient> patients = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM PATIENTS";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                String pid = resultSet.getString("pid");
                String fName = resultSet.getString("first_name");
                String mName = resultSet.getString("middle_name");
                String lName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                String emailAddress = resultSet.getString("email_address");
                String contactNo = resultSet.getString("phone_number");
                String address = resultSet.getString("address");

                Patient currPatient = new Patient(pid, fName, mName, lName, gender, dob, emailAddress, contactNo, address);
                patients.add(currPatient);
            }
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }
        return patients;
    }


    public static MedicalHistory loadMedicalHistory(String pid) {
        MedicalHistory retmh = null;
        setSchema("pms");

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String queryMR = "SELECT * FROM MEDICAL_RECORDS WHERE patient_id like " + pid;
            Statement stmtMR = conn.createStatement();
            ResultSet resultSetMR = stmtMR.executeQuery(queryMR);

            if (resultSetMR.wasNull()) {
                retmh = new MedicalHistory(pid);
            }
            else {
                MedicalHistory currMedHistory = new MedicalHistory(pid);

                String lastVisitDate = resultSetMR.getString("last_visit_date");
                int numVisits = resultSetMR.getInt("num_visits");
                String conditionsTxt = resultSetMR.getString("conditions");
                String visitsInfoTxt = resultSetMR.getString("visits_info");

                currMedHistory.setLastVisitDate(lastVisitDate);
                currMedHistory.setNumVisits(numVisits);
                retmh = currMedHistory;
            }
        }
        catch (SQLException se) {
            se.fillInStackTrace();
        }
        return retmh;
    }


    public static boolean saveDoctors(ArrayList<Doctor> doctors) {
        setSchema("pms");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "REPLACE INTO doctors (doctor_id, first_name, middle_initial, last_name, specialization) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

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
            se.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Doctor> loadDoctors() {
        setSchema("pms");
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM doctors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("doctor_id");
                String fName = rs.getString("first_name");
                String mInit = rs.getString("middle_initial");
                String lName = rs.getString("last_name");
                String specialization = rs.getString("specialization");

                Doctor doc = new Doctor(id);
                doc.setFirstName(fName);
                doc.setMiddleInitial(mInit);
                doc.setLastName(lName);
                doc.setSpecialization(specialization);
                doctors.add(doc);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.fillInStackTrace();
        }

        return doctors;
    }


    public static boolean saveAppointments(ArrayList<Appointment> appointments) {
        setSchema("pms");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "REPLACE INTO APPOINTMENTS (appointment_id, date, duration, start_time, patient_id, doctor_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            for (Appointment a:appointments) {
                stmt.setString(1, a.getAppointmentID());
                stmt.setDate(2, Date.valueOf(a.getDate()));
                stmt.setInt(3, a.getDuration());
                stmt.setTime(4, Time.valueOf(a.getStartTime()));
                stmt.setString(5, a.getPatientID());
                stmt.setString(6, a.getDoctorID());
                stmt.addBatch();
            }
            stmt.executeBatch();
            return true;

        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Appointment> loadAppointments() {
        setSchema("pms");
        ArrayList<Appointment> appointments = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM appointments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String appointmentId = rs.getString("appointment_id");
                LocalDate date = rs.getDate("date").toLocalDate();
                int duration = rs.getInt("duration");
                LocalTime startTime = rs.getTime("start_time").toLocalTime();
                String patientId = rs.getString("patient_id");
                String doctorId = rs.getString("doctor_id");

                Appointment appt = new Appointment(appointmentId, date, duration, startTime, patientId, doctorId);
                appointments.add(appt);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.fillInStackTrace();
        }

        return appointments;
    }


    public static boolean saveReceptionists(ArrayList<Receptionist> receptionists) {
        setSchema("security");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String cmd = "REPLACE INTO RECEPTIONISTS (receptionist_id, first_name, middle_name, last_name, role_title) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(cmd);
            for (Receptionist r:receptionists) {
                stmt.setString(1, r.getID());
                stmt.setString(2, r.getFName());
                stmt.setString(3, r.getMName());
                stmt.setString(4, r.getLName());
                stmt.setString(5, r.getRole().getTitle());
                stmt.addBatch();
            }
            stmt.executeBatch();
            return true;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Receptionist> loadReceptionists() {
        ArrayList<Receptionist> receptionists = new ArrayList<>();
        setSchema("security");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM RECEPTIONISTS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String rid = rs.getString(1);
                String fName = rs.getString(2);
                String mName = rs.getString(3);
                String lName = rs.getString(4);
                String roleTitle = rs.getString(5);
                receptionists.add(new Receptionist(rid, fName, mName, lName, roleTitle));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return receptionists;
    }


    public static boolean saveUsers(ArrayList<User> users) {
        setSchema("security");
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String cmd = "REPLACE INTO USERS (user_id, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(cmd);

            for (User u:users) {
                stmt.setString(1, u.getID());
                stmt.setString(2, u.getPassword());
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.close();
            System.out.println("Saved Successfully");
            return true;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public static ArrayList<User> loadUsers() {
        setSchema("security");
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM USERS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String userID = rs.getString(1);
                String password = rs.getString(2);
                User thisUser = new User(userID);
                thisUser.setPassword(password);
                users.add(thisUser);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return users;
    }

    public static User loadUser(String userID) {
        User thisUser = null;
        setSchema("security");
        String query = "SELECT * FROM USERS WHERE USER_ID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String password = rs.getString("password");
                    thisUser = new User(userID);
                    thisUser.setPassword(password);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return thisUser;
    }


    public static void saveKey(SecretKey key, String keyName) {
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        String cmd = "INSERT INTO `security`.`keys` (`key_signature`, `key_data`) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE `key_data` = VALUES(`key_data`)";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(cmd);
            stmt.setString(1, keyName);
            stmt.setString(2, encodedKey);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey loadKey(String keyName) {
        String query = "SELECT `key_data` FROM `security`.`keys` WHERE `key_signature` = ?";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, keyName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String encodedKey = rs.getString("key_data");
                byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
                return new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void saveAll(){
//        savePatients();
//        saveDoctors();
//        saveReceptionists();
//        saveUsers(AuthService.getUsers());
//        saveAppointments();
    }

    public static void main(String[] args) {

    }

} // End of Class
