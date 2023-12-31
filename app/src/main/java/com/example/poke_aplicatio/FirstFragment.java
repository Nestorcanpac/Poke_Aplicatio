package com.example.poke_aplicatio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.poke_aplicatio.databinding.FragmentFirstBinding;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Pokemon> pokemons;
    private PokemonAdapter pokemonArrayAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokemons = new ArrayList<>();

        actualizar();

        pokemonArrayAdapter = new PokemonAdapter(
                getContext(),
                R.layout.poke_list_row,
                pokemons
        );

        binding.ListaGatos.setAdapter(pokemonArrayAdapter);


        binding.ListaGatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon pokemonSelected=pokemonArrayAdapter.getItem(position);
                Bundle args=new Bundle();
                args.putString("Imagen",pokemonSelected.getImage());
                args.putString("nom",pokemonSelected.getNom());

                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment,args);
            }
        });
    }

    void actualizar() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());
        executor.execute(() -> {
            PokemonApi api = new PokemonApi();
            ArrayList<Pokemon> result = api.getPokemons();

            handler.post(() -> {
               pokemonArrayAdapter.clear();
               for (Pokemon p : result) {
                   pokemonArrayAdapter.add(p);
               }
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}