package com.example.reltyhubapp.service;

import com.example.reltyhubapp.entity.Partners;
import com.example.reltyhubapp.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnersService {
    private final PartnerRepository partnerRepository;
    public List<Partners> listPartners() {
        return partnerRepository.findAll();
    }
}
