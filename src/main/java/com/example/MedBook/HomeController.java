package com.example.MedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @GetMapping("/addPatient")
    public Patient showPatients() {
        return patientRepository.save(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));

    }
}
