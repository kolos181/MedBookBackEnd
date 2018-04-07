package com.example.MedBook;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by uuuu on 4/4/2018.
 */

@Entity
@Table(name = "patient")

public class Patient {

    public Patient(String firstName, String lastName, String sex, Date date, String state, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.date = date;
        this.state = state;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth_date")
    private Date date;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;


}
