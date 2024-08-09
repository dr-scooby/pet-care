package com.jahcodework.universal_pet_care.repository;

import com.jahcodework.universal_pet_care.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
