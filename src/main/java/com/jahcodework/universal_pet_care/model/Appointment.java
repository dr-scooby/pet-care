package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


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

    @Column(name="sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;  // the originator

    @Column(name="recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private User theVet; // the target of the appointment



    public void addPatient(User sender){
        this.patient = sender;
        if(sender.getAppointments() == null){
            sender.setAppointments(new ArrayList<>());
        }

        sender.getAppointments().add(this);
    }
}
