package com.example.jokeesingleservingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokeesingleservingapp.model.DataJokes

/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
@Database(entities = [DataJokes::class], version = 2)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokesDao?

    companion object {
        @Volatile
        private var INSTANCE: JokesDatabase? = null

        fun getDatabase(
            context: Context
        ): JokesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, JokesDatabase::class.java, "AppDatabase"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

