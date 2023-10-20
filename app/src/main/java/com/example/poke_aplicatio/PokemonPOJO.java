package com.example.poke_aplicatio;

public class PokemonPOJO {
    String name,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PokemonPOJO{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
