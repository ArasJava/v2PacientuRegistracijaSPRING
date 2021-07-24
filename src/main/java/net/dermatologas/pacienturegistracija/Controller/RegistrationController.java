package net.dermatologas.pacienturegistracija.Controller;

import net.dermatologas.pacienturegistracija.Model.Registration;
import net.dermatologas.pacienturegistracija.Repository.RegistrationRepository;
import net.dermatologas.pacienturegistracija.Exception.ResourceNotFoundException;
import net.dermatologas.pacienturegistracija.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    public RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Registration>> getAllRegistrations(){
        List<Registration> registrations = registrationService.findAllRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable("id") Long id) {
        Registration registration = registrationService.findRegistrationByID(id);
        return new ResponseEntity(registration, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration){
        Registration newRegistration = registrationService.addRegistration(registration);
        return new ResponseEntity<>(newRegistration, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Registration> updateRegistration(@RequestBody Registration registration){
        Registration updateRegistration = registrationService.updateRegistration(registration);
        return new ResponseEntity<>(updateRegistration, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegistration(@PathVariable ("id") Long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
