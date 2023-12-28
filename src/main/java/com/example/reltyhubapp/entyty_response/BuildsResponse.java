package com.example.reltyhubapp.entyty_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildsResponse {
    private Long Id;
    private String type;
    private String title;
    private String description;
    private Float price;
    private Float square_footage;
    private Integer count_of_bedrooms;
    private Integer count_of_bathrooms;
    private String city;
    private String view;
    private Integer distance_to_beach;
    private Integer floor;
    private Integer number_of_stores;
    private String type_of_dev;
    private String geo;
    private String managerName;
    private String contact;
    private boolean isPartner;
    private boolean isSold;

}
