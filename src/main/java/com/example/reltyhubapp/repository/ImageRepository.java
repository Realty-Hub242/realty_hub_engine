package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    void deleteByBuildId(Long id);
}
