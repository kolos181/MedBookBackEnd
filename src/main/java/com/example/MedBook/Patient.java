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

//    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
//    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
