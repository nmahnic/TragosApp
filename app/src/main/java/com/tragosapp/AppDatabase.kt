package com.tragosapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.tragosapp.data.model.DrinkEntity
import com.tragosapp.domain.TragosDao

@Database(entities = arrayOf(DrinkEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tragoDao(): TragosDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "tabla_tragos"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}