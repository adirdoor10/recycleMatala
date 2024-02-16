package com.example.recyclevapp;

public class DataModel {

    private String name;
    private String description;
    private int image; // Integer
    private int id_;

    public DataModel(String name, String description, int image, int id_) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id_ = id_;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.description = version;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return description;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}








