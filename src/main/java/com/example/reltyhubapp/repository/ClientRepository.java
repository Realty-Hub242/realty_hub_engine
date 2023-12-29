package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Clients, Long> {
    @Query("SELECT c FROM Clients c JOIN c.user u WHERE u.id = :userId")
    List<Clients> findClientsByUserId(@Param("userId") Long userId);

}
