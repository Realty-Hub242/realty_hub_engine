package com.example.reltyhubapp.entity;

import com.example.reltyhubapp.repository.ImageRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BUILDS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Builds {
    @Id
    private int id;
    private String TYPE_BUILD;
    private String name;
    private String description;
    private Float price;
    private Float SQUARE_FOOTAGE;
    private String view;
    private Integer distance;
    private Integer floor;
    private String typeOfDev;
    private String manager;
    private String contact;
    private String Geo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "builds")
    private List<Image> imageList = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreate;
    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }

    public void addImageToBuilds(Image image) {
        image.setBuilds(this);
        imageList.add(image);
    }

}
