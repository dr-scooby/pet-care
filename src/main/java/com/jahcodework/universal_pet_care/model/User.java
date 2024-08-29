package com.jahcodework.universal_pet_care.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 @MappedSuperclass:
  in hibernate this annotation is actually used to define a class as a superclass.

But this class is not a persistent entity.

It just holds properties that are mapped to subclasses.

Used when you have a superclass that contains common properties that need to be shared among
multiple subclasses, but the superclass itself is not a persistent entity(Not a table) in the DB.

 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(name="mobile")
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled; // is user active

    @Transient
    private String specialization; // for Vet only, do not save to user table, use Transient for this.
}
