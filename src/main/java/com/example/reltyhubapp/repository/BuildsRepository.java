package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BuildsRepository extends JpaRepository<Builds, Long> {

    List<Builds> findByTitle(String title);
    @Query("SELECT b FROM Builds b JOIN b.user u WHERE u.id = :userId")
    List<Builds> findBuildsByUserId(@Param("userId") Long userId);

}
