package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.AuthRequest;
import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.User;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.service.BuildsService;
import com.example.reltyhubapp.service.JwtService;
import com.example.reltyhubapp.service.UserInfoService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/public")
public class BuildsPublicController {

    @Autowired
    private BuildsRepository buildsRepository;
    @Autowired
    private BuildsService buildsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PermitAll
    @GetMapping("/home")
    public List<Builds> home(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("products", buildsService.listProducts(name));
        return buildsRepository.findAll();
    }

    @PostMapping(value = "/create_builds")
    public ResponseEntity<?> createBuild(@ModelAttribute Builds builds, @RequestParam("image") ArrayList<MultipartFile> file) throws IOException {
        System.out.println(file);
        buildsService.saveBuilds(builds, file);
        return new ResponseEntity<>("Builds save", HttpStatus.OK);
    }

    @PostMapping("/add_new_user")
    public String addNewUser(@RequestBody User user) {
        return userInfoService.addUser(user);
    }


    @PostMapping("/generate_token")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
