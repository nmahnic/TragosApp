package com.tragosapp.domain

import androidx.room.*
import com.tragosapp.data.model.Drink
import com.tragosapp.data.model.DrinkEntity

@Dao
interface TragosDao {

    @Query("SELECT * FROM tabla_tragos")
    suspend fun getAllFavoritesDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago: DrinkEntity)

    @Delete
    suspend fun deleteDrink(trago: DrinkEntity)
}