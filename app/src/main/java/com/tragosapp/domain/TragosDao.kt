package com.tragosapp.domain

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tragosapp.data.model.DrinkEntity

interface TragosDao {

    @Query("SELECT * FROM tabla_tragos")
    suspend fun getAllFavoritesDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago: DrinkEntity)
}