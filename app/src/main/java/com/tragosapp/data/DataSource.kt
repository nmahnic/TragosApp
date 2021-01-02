package com.tragosapp.data

import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource
import com.tragosapp.vo.RetrofitClient

class DataSource {

    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
    }
}