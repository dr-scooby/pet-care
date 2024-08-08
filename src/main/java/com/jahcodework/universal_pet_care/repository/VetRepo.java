package com.jahcodework.universal_pet_care.repository;

import com.jahcodework.universal_pet_care.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepo extends JpaRepository<Vet, Integer> {
}
