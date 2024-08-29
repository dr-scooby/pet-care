package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@ToString
@Getter
@Setter
@Entity // create as a table in the DB
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="patient_id")
public class Patient extends User {

    //@GeneratedValue(strategy = GenerationType.IDENTITY) // not really needed here
    private long id;


}
