package com.example.pokedex.api

import android.util.Log
import android.widget.Toast
import com.example.pokedex.PokemonApiResult
import com.example.pokedex.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listarPokemons(limit)

        // Chamada síncrona - não pode realizar uma operação de rede no activity, precisa ter thread
        return call.execute().body()

        // Chamada assícrona
        //call.enqueue(object: Callback<PokemonsApiResult> { ...
    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemons(number)

        return call.execute().body()
    }
}