package com.micorservices.hotelservice.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "ABOUT")
    private String about;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Hotel(String id, String name, String location, String about) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    public Hotel() {
    }

    @Override
    public String toString() {
        return "hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
