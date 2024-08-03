package com.jahcodework.universal_pet_care.model;
// the veterinarian , the doctor

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="vet_id")
public class Vet extends User{

    //@GeneratedValue(strategy = GenerationType.IDENTITY) // not really needed here
    private long id;

    private String specialization;


}
