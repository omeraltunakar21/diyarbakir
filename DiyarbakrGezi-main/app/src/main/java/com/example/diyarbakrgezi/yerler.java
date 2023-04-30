package com.example.diyarbakrgezi;

public class yerler {
    private String name, location, text;
    private int picture;
    public yerler(String name, String location, int picture, String text){
        this.name = name;
        this.location = location;
        this.text = text;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }

    public int getPicture() {
        return picture;
    }
}
