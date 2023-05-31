package com.example.ContactManagement.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private  String email;

    @Column(name = "phone")
    private String phone;


}
