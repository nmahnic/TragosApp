package com.tragosapp.data

import com.tragosapp.AppDatabase
import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.vo.Resource
import com.tragosapp.vo.RetrofitClient


class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }

    suspend fun getTragosFavoritos() : Resource<List<DrinkEntity>>{
        return Resource.Success(appDatabase.tragoDao().getAllFavoritesDrinks())
    }

    suspend fun insertTragoIntoRoom(trago: DrinkEntity){
        appDatabase.tragoDao().insertFavorite(trago)
    }
}