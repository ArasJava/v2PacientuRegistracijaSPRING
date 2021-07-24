package net.dermatologas.pacienturegistracija.Repository;

import net.dermatologas.pacienturegistracija.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long>{

    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);
}
