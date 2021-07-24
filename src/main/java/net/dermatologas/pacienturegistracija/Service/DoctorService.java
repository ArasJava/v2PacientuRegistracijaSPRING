package net.dermatologas.pacienturegistracija.Service;

import net.dermatologas.pacienturegistracija.Exception.ResourceNotFoundException;
import net.dermatologas.pacienturegistracija.Model.Doctor;
import net.dermatologas.pacienturegistracija.Model.Patient;
import net.dermatologas.pacienturegistracija.Repository.DoctorRepository;
import net.dermatologas.pacienturegistracija.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        doctor.setDoctorCode(UUID.randomUUID().toString());
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor findDoctorByID(Long id) {
        return doctorRepository.findDoctorById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pciento su id " + id + " nerasta." ));
    }
    public void deleteDoctor(Long id) {
        doctorRepository.deleteDoctorById(id);
    }
}
