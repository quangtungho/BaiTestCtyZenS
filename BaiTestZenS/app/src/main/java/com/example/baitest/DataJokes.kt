package com.example.baitest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
@Entity
class DataJokes(contentJokes: String? = "") {
    @PrimaryKey(autoGenerate = true)
    var jokesId: Long = 0

    @ColumnInfo(name = "content")
    var content: String? = contentJokes
}
