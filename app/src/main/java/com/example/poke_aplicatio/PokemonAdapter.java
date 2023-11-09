package com.example.poke_aplicatio;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(@NonNull Context context, int resource, List<Pokemon> pokemons) {
        super(context, resource, pokemons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.poke_list_row, parent, false);
        }

        TextView NamePokemon = convertView.findViewById(R.id.NamePokemon);
        TextView AlturaPokemon = convertView.findViewById(R.id.alturaPokemon);
        TextView PesoPokemon = convertView.findViewById(R.id.Peso);
        ImageView ImagenPoke= convertView.findViewById(R.id.imagenPokemon);

        NamePokemon.setText(pokemon.getNom());
        AlturaPokemon.setText("Altura: "+ pokemon.getHeight());
        PesoPokemon.setText("Peso: "+pokemon.getWeight());
        Picasso.get().load(pokemon.getImage()).into(ImagenPoke);



        return convertView;
    }
}
