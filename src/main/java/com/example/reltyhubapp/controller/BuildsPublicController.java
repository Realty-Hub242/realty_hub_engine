package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/public")
@RequiredArgsConstructor
public class BuildsPublicController {

    @Autowired
    private final BuildsRepository buildsRepository;

    @GetMapping("/home")
    public List<Builds> home() {
        return buildsRepository.getAllBuilds();
    }

    @PostMapping("/create_builds")
    public void createBuild() {
        System.out.println("HERE");
    }
}
