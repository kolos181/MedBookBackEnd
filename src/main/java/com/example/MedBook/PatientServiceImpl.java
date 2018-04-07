package com.example.MedBook;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by uuuu on 4/8/2018.
 */

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        sessionFactory.getCurrentSession().save(patient);
    }
}
