package com.tragosapp.domain

import com.tragosapp.data.DataSource
import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {
    override suspend fun getTragosList(tragoName : String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }


}