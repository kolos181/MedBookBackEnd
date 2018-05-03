package com.example.MedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by uuuu on 4/4/2018.
 */

@RestController
@RequestMapping("/")
public class HomeController {

    private final PatientRepository patientRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public HomeController(PatientRepository patientRepository, CommentRepository commentRepository) {
        this.patientRepository = patientRepository;
        this.commentRepository = commentRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/api/addPatient")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);

    }

    @GetMapping("/api/patients")
    public List<Patient> findPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @GetMapping("/api/getPatient/{id}")
    public Patient findById(@PathVariable(value = "id") Long patientId) {
        Optional<Patient> patient = Optional.of(patientRepository.getOne(patientId));
        return patient.get();
    }

    @DeleteMapping("/api/deletePatient/{id}")
    public void deleteById(@PathVariable(value = "id") Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
