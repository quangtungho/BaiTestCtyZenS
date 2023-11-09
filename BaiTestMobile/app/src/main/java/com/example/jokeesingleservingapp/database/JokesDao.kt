package com.example.jokeesingleservingapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jokeesingleservingapp.model.DataJokes

/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
@Dao
interface JokesDao {

    @Insert
    fun insertJokes(dataJokes: DataJokes?)

    @Query("select * from JOKES_TABLE")
    fun getAllTasks(): List<DataJokes>
}