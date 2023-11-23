package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Builds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BuildsRepository extends JpaRepository<Builds, Long> {

    List<Builds> findByTitle(String title);

}
