package com.example.MedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/addPatient")
    public Patient addPatient() {
        return patientRepository.save(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));

    }

    @GetMapping("/getPatient")
    public Optional<Patient> getPatient() {
        return patientRepository.findById(1L);
    }
}
