package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Builds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BuildsRepository extends JpaRepository<Builds, Long> {
    @Query(value = "SELECT b FROM Builds b")
    List<Builds> getAllBuilds();

    @Query(value = "SELECT b FROM Builds b WHERE b.id = :id")
    Builds getBuildsById(@Param("id") int id);

    @Query(value = "SELECT max(b.id) FROM Builds b")
    Optional<Long> getMaxId();
}
