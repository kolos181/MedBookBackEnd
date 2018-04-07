package com.example.MedBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by uuuu on 4/4/2018.
 */

@Controller
@RequestMapping("/notNow")
public class HomeController {

    private final PatientRepository patientRepository;

    private final CommentRepository commentRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    public HomeController(PatientRepository patientRepository, CommentRepository commentRepository) {
        this.patientRepository = patientRepository;
        this.commentRepository = commentRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPatients(ModelMap modelMap) {
        patientService.addPatient(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));
        patientService.addPatient(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));
        patientService.addPatient(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));
        patientService.addPatient(new Patient("Elder", "Galmeister", "Male",
                new Date(1L), "Utah", "Bob st. 1"));

//        List<Patient> patientList = patientRepository.findAll();
//        modelMap.addAttribute("patients", patientList);
        return "frontPage";
    }
}
