package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.User;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.service.BuildsService;
import com.example.reltyhubapp.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/private")
@RequiredArgsConstructor
public class BuildsUserController {

    @Autowired
    private BuildsRepository buildsRepository;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private BuildsService buildsService;

    @PostMapping("/create_builds")
    public ResponseEntity<?> createBuild(@ModelAttribute Builds builds, @RequestParam("image") ArrayList<MultipartFile> file) throws IOException {
        System.out.println(file);
        buildsService.saveBuilds(builds, file);
        return new ResponseEntity<>("Builds save", HttpStatus.OK);
    }

    @PostMapping("/add_new_user")
    public String addNewUser(@ModelAttribute User user) {
        return userInfoService.addUser(user);
    }

    @GetMapping("/home_user")
    public String userProfile(){
        return "Welcome to User Profile";
    }
}
