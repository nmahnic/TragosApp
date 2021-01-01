package com.tragosapp.data

import com.tragosapp.data.model.Drink
import com.tragosapp.vo.Resource

class DataSource {

    private val generateTragosList = listOf(
        Drink("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.JMTjbCZbfvvfdO6eQLMUxwHaEo%26pid%3DApi&f=1", "Margarita", "Con azucar, vodka y nueces"),
        Drink("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.sc12IKWaJuB4mcb3smo2bwHaHa%26pid%3DApi&f=1", "Fernet", "Fernet con coca y 2 hielos"),
        Drink("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.A6paM2CySDdrGl1eXqdOUwHaFj%26pid%3DApi&f=1", "Toro", "Toro con pritty"),
        Drink("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.Of1m4KHUaxL9e4ABN-YJ9QHaHX%26pid%3DApi&f=1","Gancia","Gancia con sprite")
    )

    fun getTragosList() : Resource<List<Drink>>{
        return Resource.Success(generateTragosList)
    }
}