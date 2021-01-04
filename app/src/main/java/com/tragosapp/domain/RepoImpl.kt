package com.tragosapp.domain

import com.tragosapp.data.DataSource
import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {
    override suspend fun getTragosList(tragoName : String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragosFavoritos()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        dataSource.insertTragoIntoRoom(trago)
    }

    override suspend fun deleteTrago(trago: DrinkEntity){
        dataSource.deleteTrago(trago)
    }

}