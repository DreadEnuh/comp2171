package patient_management;

import database.PatientDatabase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PatientService {

    private final PatientDatabase patientDatabase;

    public PatientService() {
        this.patientDatabase = new PatientDatabase();
    }

    private Patient createPatientFromDTO(PatientDTO dto) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dob = LocalDate.parse(dto.getDateOfBirth(), formatter);
            return new Patient(
                    dto.getFName(),
                    dto.getMName(),
                    dto.getLName(),
                    dto.getGender(),
                    dob,
                    dto.getEmail(),
                    dto.getContactNumber(),
                    dto.getAddress()
            );
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public boolean registerPatient(PatientDTO dto) {
        if (dto == null || dto.getFName() == null || dto.getMName() == null || dto.getLName() == null) {
            return false;
        }

        Patient newPatient = createPatientFromDTO(dto);
        return patientDatabase.addPatient(newPatient);
    }

    public Patient getPatientDetails(String patientID) {
        return patientDatabase.getPatientByID(patientID);
    }

    public boolean updatePatientInfo(String patientID, PatientDTO dto) {
        Patient existing = patientDatabase.getPatientByID(patientID);
        if (existing == null) return false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dob = LocalDate.parse(dto.getDateOfBirth(), formatter);
            existing.setDob(dob);
            existing.setFName(dto.getFName());
            existing.setMName(dto.getMName());
            existing.setLName(dto.getLName());
            existing.setGender(dto.getGender());
            existing.setEmail(dto.getEmail());
            existing.setContactNumber(dto.getContactNumber());
            existing.setAddress(dto.getAddress());
            return patientDatabase.updatePatient(existing);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public List<Patient> getAllPatients() {
        return patientDatabase.getAllPatients();
    }
}
