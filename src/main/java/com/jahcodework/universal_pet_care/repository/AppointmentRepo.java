package com.jahcodework.universal_pet_care.repository;


import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.model.User;
import jakarta.persistence.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {


    Appointment findByAppointmentNo(String appointmentNo);

    Appointment findByReason(String reason);

    Appointment findByDate(LocalDate date);

    Appointment findByCreatedAt(LocalDate date);

    Appointment findBySender(User patient);

    Appointment findByRecipient(User theVet);

    Appointment findByStatus(String status);
}
