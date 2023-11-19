package com.example.reltyhubapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class RealtyHubAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealtyHubAppApplication.class, args);
    }

}
