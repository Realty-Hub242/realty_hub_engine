package com.example.reltyhubapp.controller;

import com.example.reltyhubapp.entity.Builds;
import com.example.reltyhubapp.entity.Clients;
import com.example.reltyhubapp.entity.User;
import com.example.reltyhubapp.entyty_response.ClientResponse;
import com.example.reltyhubapp.repository.BuildsRepository;
import com.example.reltyhubapp.repository.ClientRepository;
import com.example.reltyhubapp.repository.UserRepository;
import com.example.reltyhubapp.service.BuildsService;
import com.example.reltyhubapp.service.ClientService;
import com.example.reltyhubapp.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://realtyhubreact-production.up.rp")
@RequestMapping(value = "/private")
@RequiredArgsConstructor
public class BuildsUserController {

    @Autowired
    private BuildsRepository buildsRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private BuildsService buildsService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create_builds")
    public ResponseEntity<?> createBuild(@ModelAttribute Builds builds, @RequestParam("image") ArrayList<MultipartFile> file) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUserName(username).orElse(null);
        builds.setUser(user);
        builds.setManager(user.getName());
        builds.setContact(user.getNumberPhone());
        buildsService.saveBuilds(builds, file);
        return new ResponseEntity<>("Builds save", HttpStatus.OK);
    }

    @PostMapping("/add_new_user")
    public String addNewUser(@ModelAttribute User user) {
        return userInfoService.addUser(user);
    }

    @PostMapping("/add_new_client")
    public ResponseEntity<?> addNewClient(@ModelAttribute Clients client) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        client.setUser(userRepository.findByUserName(username).orElse(null));
        client.setManagerName(userRepository.findByUserName(username).orElse(null).getName());
        clientService.createClient(client);
        return new ResponseEntity<>("Client save", HttpStatus.OK);
    }

    @GetMapping("/clients")
    public List<ClientResponse> getClients() {
        List<Clients> clients = clientRepository.findAll();
        List<ClientResponse> clientResponseList = new ArrayList<>();

        for(Clients client : clients) {
            ClientResponse clientResponse = new ClientResponse();
            clientResponse.setId(client.getID());
            clientResponse.setFirstName(client.getFirstName());
            clientResponse.setLastName(client.getLastName());
            clientResponse.setNumberPhone(client.getNumberPhone());
            clientResponse.setIncome(client.getIncome());
            clientResponse.setType(client.getType());
            clientResponse.setDescription(client.getDescription());
            clientResponse.setEmail(client.getEmail());

            if (client.getUser() != null) {
                clientResponse.setManagerName(client.getUser().getName());
            }

            clientResponseList.add(clientResponse);
        }
        return clientResponseList;
    }

    @GetMapping("/get_build/{id}")
    public ResponseEntity<Builds> getBuildsById(@PathVariable Long id) {
        Builds build = buildsRepository.findById(id).orElseThrow(null);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

    @GetMapping("/delete_build/{id}")
    public ResponseEntity<?> deleteBuildById(@PathVariable Long id) {
        buildsRepository.deleteById(id);
        return new ResponseEntity<>("The Build deleted OK", HttpStatus.OK);
    }

    @PutMapping("/edit_build/{id}")
    public ResponseEntity<?> editBuild (@PathVariable Long id, @ModelAttribute Builds builds, @RequestParam("image") ArrayList<MultipartFile> file) throws IOException {
        buildsService.editBuilds(id, builds, file);
        return new ResponseEntity<>("Builds updated successfully", HttpStatus.OK);
    }

    @GetMapping("/get_user/{username}")
    public ResponseEntity<?> getUserData(@PathVariable String username) {
        User user = userRepository.findByUserName(username).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get_builds_by_manager")
    public ResponseEntity<?> getBuildsByManager() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUserName(username).orElse(null);
        List<Builds> buildsList = buildsRepository.findBuildsByUserId(user.getID());
        return new ResponseEntity<>(buildsList, HttpStatus.OK);
    }

    @GetMapping("/get_clients_by_manager")
    public ResponseEntity<?> getClientsByManager() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUserName(username).orElse(null);
        List<Clients> clientsList = clientRepository.findClientsByUserId(user.getID());
        return new ResponseEntity<>(clientsList, HttpStatus.OK);
    }
}
