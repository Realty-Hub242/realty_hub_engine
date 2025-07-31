package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.AuthRequest;
import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.service.BuildsService;
import com.example.reltyhubapp.service.JwtService;
import com.example.reltyhubapp.service.UserInfoService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
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

    @PermitAll
    @GetMapping("/details_lot/{id}")
    public ResponseEntity<Builds> getBuildsById(@PathVariable Long id) {
        Builds builds = buildsRepository.findById(id).orElseThrow(() -> new RuntimeException("Build not found with id: " + id));
        return new ResponseEntity<>(builds, HttpStatus.OK);
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
