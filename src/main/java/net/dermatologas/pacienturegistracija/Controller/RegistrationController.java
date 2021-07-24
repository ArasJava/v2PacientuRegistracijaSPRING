package net.dermatologas.pacienturegistracija.Controller;

import net.dermatologas.pacienturegistracija.Model.Registration;
import net.dermatologas.pacienturegistracija.Repository.RegistrationRepository;
import net.dermatologas.pacienturegistracija.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {
    @Autowired
    public RegistrationRepository registrationRepository;
    @GetMapping("/registrations")
    public List<Registration> getAllSpecialists(){
        return registrationRepository.findAll();
    }
    @GetMapping("/registrations/{id}")
    public ResponseEntity<Registration> getSpecialistById(@PathVariable Long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Registracijos nėra su tokiu id " + id));
        return ResponseEntity.ok(registration);
    }
    @PostMapping("/registrations")
    public Registration createSpecialist(@RequestBody Registration registration){
        return registrationRepository.save(registration);
    }
    @PutMapping("/registrations/{id}")
    public ResponseEntity<Registration> updateSpecialist(@PathVariable Long id, @RequestBody Registration registrationDetails){
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Specialisto nėra su tokiu id " + id));
        registration.setPatientId(registrationDetails.getPatientId());
        registration.setDoctorID(registrationDetails.getDoctorID());
        registration.setDate(registrationDetails.getDate());
        registration.setTime(registrationDetails.getTime());
        registration.setPurpose(registrationDetails.getPurpose());
        registration.setMessage(registrationDetails.getMessage());
        Registration updatedRegistration = registrationRepository.save(registration);
        return ResponseEntity.ok(updatedRegistration);
    }
}
