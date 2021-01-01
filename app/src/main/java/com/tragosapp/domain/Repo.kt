package com.tragosapp.domain

import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource

interface Repo {
    fun getTragosList() : Resource<List<Drink>>
}