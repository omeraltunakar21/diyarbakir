package com.example.diyarbakrgezi;

public class oteller {
    String name, location, number, text, fiyat;
    int picture;
    String[] imageLink = {};

    public oteller(String name, String location, String number, String text, String fiyat, int picture, String[] imageLink) {
        this.imageLink = imageLink;
        this.picture = picture;
        this.fiyat = fiyat;
        this.name = name;
        this.location = location;
        this.number = number;
        this.text = text;
    }
}
