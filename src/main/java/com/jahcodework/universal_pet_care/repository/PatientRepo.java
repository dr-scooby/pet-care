package com.jahcodework.universal_pet_care.repository;

import com.jahcodework.universal_pet_care.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
