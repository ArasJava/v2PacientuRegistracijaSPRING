package net.dermatologas.pacienturegistracija.Service;

import net.dermatologas.pacienturegistracija.Model.Patient;
import net.dermatologas.pacienturegistracija.Repository.PatientRepository;
import net.dermatologas.pacienturegistracija.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        patient.setPatientCode(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pciento su id " + id + " nerasta." ));
    }
    public void deletePatient(Long id) {
        patientRepository.deletePatientById(id);
    }
}
