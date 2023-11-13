package com.example.reltyhubapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "BUILDS")
public class Builds {
    @Id
    private int id;
    private String TYPE_BUILD;
    private String name;
    private String description;
    private Float price;
    private Float SQUARE_FOOTAGE;
    private String view;
    private Integer distance;
    private Integer floor;
    private String typeOfDev;
    private String menager;
    private String contact;

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeOfBuild(String typeOfBuild) {
        if (typeOfBuild == null) {
            this.TYPE_BUILD = "DEFAULT";
        }
        this.TYPE_BUILD = typeOfBuild;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        if (price == null) {
            this.price = (float) -1;
        }
        this.price = price;
    }

    public void setSqrtMeters(Float sqrtMeters) {
        if (sqrtMeters == null) {
            this.SQUARE_FOOTAGE = (float) -1;
        }
        this.SQUARE_FOOTAGE = sqrtMeters;
    }

    public void setView(String view) {
        if (view == null) {
            this.view = "empty";
        }
        this.view = view;
    }

    public void setDistance(Integer distance) {
        if (distance == null) {
            this.distance = -1;
        }
        this.distance = distance;
    }

    public void setFloor(Integer floor) {
        if (floor == null) {
            this.floor = -1;
        }
        this.floor = floor;
    }

    public void setTypeOfDev(String typeOfDev) {
        this.typeOfDev = typeOfDev;
    }

    public void setManager(String manager) {
        if (manager == null) {
            this.menager = "ADMIN";
        }
        this.menager = manager;
    }

    public void setContact(String contact) {
        if (contact == null) {
            this.contact = "DEFAULT";
        }
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getTypeOfBuild() {
        return TYPE_BUILD;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Float getSqrtMeters() {
        return SQUARE_FOOTAGE;
    }

    public String getView() {
        return view;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getTypeOfDev() {
        return typeOfDev;
    }

    public String getManager() {
        return menager;
    }

    public String getContact() {
        return contact;
    }
}
