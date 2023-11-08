package com.example.baitest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.example.baitest.DataJokes

/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
@Dao
interface JokesDao {
    @Insert(onConflict = REPLACE)
    fun insertJokes(dataJokes: DataJokes?)

}