package com.example.diyarbakrgezi;

public class yemekler {
    String name, location, text, aciklama;
    int picture;
    String[] imageLink = {};

    public yemekler(String name, String location,String text, String aciklama, int picture, String[] imageLink) {
        this.aciklama = aciklama;
        this.imageLink = imageLink;
        this.picture = picture;
        this.name = name;
        this.location = location;
        this.text = text;
    }

}
