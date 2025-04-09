package patient_management;

import database.PatientDatabase;

import java.time.LocalDate;
import java.util.List;

public class PatientService {

    private final PatientDatabase PatientDatabase;

    public PatientService() {
        this.PatientDatabase = new PatientDatabase();
    }

    public boolean registerPatient(PatientDTO dto) {
        if (dto == null || dto.getFName() == null || dto.getMName() == null || dto.getLName() == null) {
            return false;
        }

        Patient newPatient = new Patient(
                dto.getFName(),
                dto.getMName(),
                dto.getLName(),
                dto.getGender(),
                dto.getDateOfBirth(),
                dto.getEmail(),
                dto.getContactNumber(),
                dto.getAddress()
        );

        return PatientDatabase.addPatient(newPatient);
    }

    public Patient getPatientDetails(String patientID) {
        return PatientDatabase.getPatientByID(patientID);
    }

    public boolean updatePatientInfo(String patientID, PatientDTO dto) {
        Patient existing = PatientDatabase.getPatientByID(patientID);
        if (existing == null) return false;

        existing.setFName(dto.getFName());
        existing.setMName(dto.getMName());
        existing.setLName(dto.getLName());
        existing.setGender(dto.getGender());
        existing.setDob(LocalDate.parse(dto.getDateOfBirth()));
        existing.setEmail(dto.getEmail());
        existing.setContactNumber(dto.getContactNumber());
        existing.setAddress(dto.getAddress());

        return PatientDatabase.updatePatient(existing);
    }

    public List<Patient> getAllPatients() {
        return PatientDatabase.getAllPatients();
    }
}