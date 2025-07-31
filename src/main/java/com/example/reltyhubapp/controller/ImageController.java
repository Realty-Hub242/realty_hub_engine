package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Image;
import com.example.reltyhubapp.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://realtyhubreact-production.up.railway.app")
@RequestMapping(value = "/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElseThrow(null);
        return ResponseEntity.ok().header("fileName", image.getOriginalName())
                .contentLength(image.getSize()).body(new ByteArrayResource(image.getBytes()));
    }
}
