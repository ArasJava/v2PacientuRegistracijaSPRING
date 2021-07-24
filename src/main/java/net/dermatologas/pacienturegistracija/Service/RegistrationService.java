package net.dermatologas.pacienturegistracija.Service;

import net.dermatologas.pacienturegistracija.Exception.ResourceNotFoundException;
import net.dermatologas.pacienturegistracija.Model.Patient;
import net.dermatologas.pacienturegistracija.Model.Registration;
import net.dermatologas.pacienturegistracija.Repository.PatientRepository;
import net.dermatologas.pacienturegistracija.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration addRegistration(Registration registration) {
        registration.setRegistrationCode(UUID.randomUUID().toString());
        return registrationRepository.save(registration);
    }

    public List<Registration> findAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration updateRegistration(Registration registration){
        return registrationRepository.save(registration);
    }

    public Registration findRegistrationByID(Long id) {
        return registrationRepository.findRegistrationById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Registracijos su id " + id + " nerasta." ));
    }
    public void deleteRegistration(Long id) {
        registrationRepository.deleteRegistrationById(id);
    }
}
