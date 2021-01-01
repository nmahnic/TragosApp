package com.tragosapp.domain

import com.tragosapp.data.DataSource
import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {
    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.getTragosList()
    }


}