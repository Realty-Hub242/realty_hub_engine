package com.example.reltyhubapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String firstName;
    private String lastName;
    private String email;
    private String numberPhone;
    private String type;
    private Integer income;
    private String description;
    private String manager;
}
