package com.tragosapp.domain

import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.vo.Resource

interface Repo {

    suspend fun getTragosList(tragoName : String) : Resource<List<Drink>>
    suspend fun getTragosFavoritos() : Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago: DrinkEntity)
    suspend fun deleteTrago(drink: DrinkEntity)
}