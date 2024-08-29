package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity // create as a table in the DB
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="admin_id")
public class Admin extends User{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // not really needed here
    private long id;



}
