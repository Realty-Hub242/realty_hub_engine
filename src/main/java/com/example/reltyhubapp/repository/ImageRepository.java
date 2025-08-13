package com.example.reltyhubapp.repository;

import com.example.reltyhubapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ImageRepository extends JpaRepository<Image, Long> {


    @Transactional
    @Modifying
    @Query("DELETE FROM Image i WHERE i.builds.id = :buildId")
    void deleteByBuildsId(Long buildId);

}