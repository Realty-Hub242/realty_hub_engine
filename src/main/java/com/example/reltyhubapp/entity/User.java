package com.example.reltyhubapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_name"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    @JsonIgnore
    private String userName;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String roles;
    private String numberPhone;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Clients> clientsList = new ArrayList<>();

    public void addClientToUser(Clients clients) {
        clients.setUser(this);
        clientsList.add(clients);
    }


}
