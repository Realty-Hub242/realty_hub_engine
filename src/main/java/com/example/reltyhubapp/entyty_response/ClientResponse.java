package com.example.reltyhubapp.entyty_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Long Id;
    private String managerName;
    private String firstName;
    private String lastName;
    private String email;
    private String numberPhone;
    private String type;
    private Integer income;
    private String description;
}
