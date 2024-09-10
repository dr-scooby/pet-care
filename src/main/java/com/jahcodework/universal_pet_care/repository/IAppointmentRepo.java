package com.jahcodework.universal_pet_care.repository;


import com.jahcodework.universal_pet_care.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment, Long> {
}
