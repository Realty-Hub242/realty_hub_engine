package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.Image;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.repository.UserRepository;
import com.example.reltyhubapp.service.BuildsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/public")
@RequiredArgsConstructor
public class BuildsPublicController {

    @Autowired
    private final BuildsRepository buildsRepository;
    @Autowired
    private final BuildsService buildsService;

    @GetMapping("/home")
    public List<Builds> home() {
        return buildsRepository.getAllBuilds();
    }

    @PostMapping(value = "/create_builds")
    public ResponseEntity<String> createBuild(@RequestBody Builds builds) throws IOException {
        Optional<Long> ID_OPTIONAL = buildsRepository.getMaxId();
        if (ID_OPTIONAL.isPresent()) {
            Long ID = ID_OPTIONAL.get();
            ID = ID + 1;
            builds.setId(ID);
        } else {
            builds.setId(new Random().nextLong());
        }

        //buildsService.saveBuilds(builds, image);
        buildsRepository.save(builds);
        System.out.println(builds);
        return new ResponseEntity<String>("Builds save", HttpStatus.OK);
    }

}
