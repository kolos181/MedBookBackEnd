package com.example.MedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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


    @PostMapping("/api/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/api/patients")
    public List<Patient> findPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @GetMapping("/api/patients/{id}")
    public Patient findById(@PathVariable(value = "id") Long patientId) {
        Optional<Patient> patient = Optional.of(patientRepository.getOne(patientId));
        return patient.get();
    }

    @DeleteMapping("/api/patients/{id}")
    public void deleteById(@PathVariable(value = "id") Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @PutMapping("/api/patients/{id}")
    public Patient updatePatientById(@PathVariable Long id, @Valid @RequestBody Patient patient) {
        Patient localPatient = new Patient();

        localPatient.setId(id);
        localPatient.setName(patient.getName());
        localPatient.setSex(patient.getSex());
        localPatient.setState(patient.getState());
        localPatient.setAddress(patient.getAddress());
        localPatient.setDate(patient.getDate());
        localPatient.setUpdatedAt(new Date());
        patientRepository.save(localPatient);
        return localPatient;
    }

//    @PutMapping("/api/patients")
//    public Patient updatePatientByJson(@Valid @RequestBody Patient patient) {
//        return patientRepository.save(patient);
//    }
}
