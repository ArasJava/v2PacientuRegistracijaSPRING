package net.dermatologas.pacienturegistracija.Controller;

import net.dermatologas.pacienturegistracija.Model.Doctor;
import net.dermatologas.pacienturegistracija.Repository.DoctorRepository;
import net.dermatologas.pacienturegistracija.Exception.ResourceNotFoundException;
import net.dermatologas.pacienturegistracija.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.findAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable ("id") Long id) {
        Doctor doctor = doctorService.findDoctorByID(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addeDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        Doctor updateDoctor = doctorService.updateDoctor(doctor);
        return new ResponseEntity<>(updateDoctor, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
