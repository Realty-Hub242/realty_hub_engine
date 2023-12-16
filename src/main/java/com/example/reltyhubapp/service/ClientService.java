package com.example.reltyhubapp.service;

import com.example.reltyhubapp.entity.Clients;
import com.example.reltyhubapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Clients> listClients() {
        return clientRepository.findAll();
    }

    public void createClient(Clients clients) throws IOException {
        clientRepository.save(clients);
    }

}
