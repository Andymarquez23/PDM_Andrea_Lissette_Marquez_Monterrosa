package com.example.laboratorio4.DataBase

import android.app.Application
import androidx.room.Room

class InitDatabase : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "TaskDatabase"
        ).build()
    }
}