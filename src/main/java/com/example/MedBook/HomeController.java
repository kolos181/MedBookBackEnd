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


    @DeleteMapping("/api/patients")
    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }

    @PutMapping("/api/patients")
    public Patient addComment(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/api/patients/search/{name}")
    public List<Patient> findPatientsByName(@PathVariable(value = "name") String name) {

        return this.patientRepository.findPatientsByNameIsStartingWithIgnoreCase(name);
    }
    /////////////////////////////////////////
    //Comments controller part

    @GetMapping("api/comments/{id}")
    public List<Comments> findPatientComments(@PathVariable(value = "id") Long patientId) {
        List<Comments> comments = Optional.of(commentRepository.findPatientWithComments(patientId)).get();
        return comments;
    }

    @PostMapping("/api/comments")
    public Comments addComment(@Valid @RequestBody Comments comments) {
        return commentRepository.save(comments);
    }

    @DeleteMapping("/api/comments")
    public void deleteAllComments() {
        commentRepository.deleteAll();
    }

    @DeleteMapping("/api/comments/{id}")
    void deleteComment(@PathVariable(value = "id") Long id) {
        this.commentRepository.deleteById(id);
    }
}
