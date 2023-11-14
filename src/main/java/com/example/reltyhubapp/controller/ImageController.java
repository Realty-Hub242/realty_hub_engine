package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Image;
import com.example.reltyhubapp.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/public")
public class ImageController {
    private final ImageRepository imageRepository;

    @PreAuthorize("permitAll")
    @GetMapping("/image/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElseThrow(null);
        return ResponseEntity.ok().header("fileName", image.getOriginalName())
                .contentLength(image.getSize()).body(new ByteArrayResource(image.getBytes()));
    }
}
