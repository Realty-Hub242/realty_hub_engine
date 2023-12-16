package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, Long> {

}
