package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

// video # 78

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    @Column(name="appointment_date")
    private LocalDate date;
    @Column(name="appointment_time")
    private LocalTime time;
    private String appointmentNo;
    private LocalDate createdAt; // when this first created

    @JoinColumn(name="sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;  // the originator, the patient the customer the client

    @JoinColumn(name="recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private User theVet; // the target of the appointment



    // video # 78
    // add user to the appointments
    public void addPatient(User sender){
        this.patient = sender;
        if(sender.getAppointments() == null){
            sender.setAppointments(new ArrayList<>());
        }

        sender.getAppointments().add(this);
    }

    // add Vet to the appointments
    public void addVetAppt(User avet){
        this.theVet = avet;

        if(avet.getAppointments() == null){
            avet.setAppointments(new ArrayList<>());
        }

        avet.getAppointments().add(this);
    }


    // generate the appointmentNo
    public void setAppointmentNo(){
        // 100 numbers, random - testing for now
        this.appointmentNo = String.valueOf(new Random().nextLong()).substring(1,101);
    }
}
