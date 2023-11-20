package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.service.BuildsService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/public")
@RequiredArgsConstructor
public class BuildsPublicController {

    @Autowired
    private final BuildsRepository buildsRepository;
    @Autowired
    private final BuildsService buildsService;

    @PermitAll
    @GetMapping("/home")
    public List<Builds> home(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("products", buildsService.listProducts(name));
        return buildsRepository.findAll();
    }

    @PostMapping(value = "/create_builds")
    public ResponseEntity<?> createBuild(Builds builds, @RequestParam("image") MultipartFile file) throws IOException {
        buildsService.saveBuilds(builds, file);
        return new ResponseEntity<>("Builds save", HttpStatus.OK);
    }

}
