package com.example.laboratorio4.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.laboratorio4.Model.Task

@Database(
    entities = [Task::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}