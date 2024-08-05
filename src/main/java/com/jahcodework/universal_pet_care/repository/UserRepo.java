package com.jahcodework.universal_pet_care.repository;

import com.jahcodework.universal_pet_care.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
