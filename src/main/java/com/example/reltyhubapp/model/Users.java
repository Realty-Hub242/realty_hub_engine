package com.example.reltyhubapp.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Users {
    private String userName;
    private byte[] password;

    private boolean admin;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");

        this.password = md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] getPassword() {
        return password;
    }
}
