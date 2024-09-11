package com.jahcodework.universal_pet_care.repository;


import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.model.User;
import jakarta.persistence.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    /*
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

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
     */


    Appointment findByAppointmentNo(String appointmentNo);

    Appointment findByReason(String reason);

    Appointment findByDate(LocalDate date);

    Appointment findByCreatedAt(LocalDate date);

    Appointment findBySender(User patient);

    Appointment findByRecipient(User theVet);

    Appointment findByStatus(String status);
}
