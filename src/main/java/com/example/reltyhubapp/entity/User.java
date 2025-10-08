package com.example.reltyhubapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "user_name" }),
        @UniqueConstraint(columnNames = { "email" }),
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;

    private String userName;

    private String email;

    private String password;

    private String roles;

    private String numberPhone;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "user"
    )
    private List<Clients> clientsList = new ArrayList<>();

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "user"
    )
    private List<Builds> buildsList = new ArrayList<>();

    public void addClientToUser(Clients clients) {
        clients.setUser(this);
        clientsList.add(clients);
    }

    public void addBuildsToUser(Builds builds) {
        builds.setUser(this);
        buildsList.add(builds);
    }
}
