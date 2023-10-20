package com.example.poke_aplicatio;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class PokemonApi {


    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    ArrayList<Pokemon> getPokemons() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("pokemon")
                .appendQueryParameter("Limit","5")
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private ArrayList<Pokemon> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Pokemon> processJson(String JsonResponse){
        ArrayList<Pokemon> listaPokes = new ArrayList<>();
        try{

            JSONObject jsonObject = new JSONObject(JsonResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i=0 ; i < jsonArray.length() ; i++){
                JSONObject pokeJson = jsonArray.getJSONObject(i);

                Pokemon poke1 = new Pokemon();
                poke1.setNom(pokeJson.getString("name"));
                poke1.setDetailURL(pokeJson.getString("url"));

                String resultDetail = HttpUtils.get(poke1.getDetailURL());

                JSONObject jsonObject1=new JSONObject(resultDetail);

                poke1.setHeight(jsonObject1.getInt("height"));
                poke1.setWeight(jsonObject1.getInt("weight"));

                JSONObject sprites = jsonObject1.getJSONObject("sprites");
                poke1.setImage(sprites.getString("front_default"));

                listaPokes.add(poke1);

            }
        }
        catch (Exception ex1){
            ex1.printStackTrace();
        }
        return listaPokes;
    }





}
