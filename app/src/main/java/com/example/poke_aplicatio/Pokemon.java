package com.example.poke_aplicatio;

public class Pokemon {
    private String nom, detailURL,Image;
    private int weight,height;

    public String getNom() {
        return nom;
    }

    public String getDetailURL() {
        return detailURL;
    }

    public String getImage() {
        return Image;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Pokemon() {
    }

    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pokemon(String nom, String url, String speciesName, String image, int vida, int ataque) {
        this.nom = nom;

    }
}
