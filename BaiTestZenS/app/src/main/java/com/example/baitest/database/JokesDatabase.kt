package com.example.baitest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.baitest.DataJokes

@Database(entities = [DataJokes::class], version = 1)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokesDao?

    companion object {
        private var INSTANCE: JokesDatabase? = null
        fun getInMemoryDatabase(context: Context): JokesDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    JokesDatabase::class.java
                ) // To simplify the codelab, allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

