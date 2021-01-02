package com.tragosapp.domain

import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName : String) : Resource<List<Drink>>
}