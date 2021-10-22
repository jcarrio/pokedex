package com.example.pokedex.api

import com.example.pokedex.PokemonApiResult
import com.example.pokedex.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listarPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemons(@Path("number") number: Int): Call<PokemonApiResult>
}