package com.example.reltyhubapp.payload;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
