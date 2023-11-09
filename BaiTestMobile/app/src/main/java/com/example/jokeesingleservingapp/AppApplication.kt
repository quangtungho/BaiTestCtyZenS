package com.example.jokeesingleservingapp

import android.app.Application
import com.example.jokeesingleservingapp.database.JokesDatabase

/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
class AppApplication : Application() {

    companion object {
        var mDb: JokesDatabase? = null
        //var dao: JokesDao? = null
    }

    override fun onCreate() {
        super.onCreate()
        mDb = JokesDatabase.getDatabase(this)
        // dao = mDb!!.jokesDao()
    }
}