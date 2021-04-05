package com.example.room_database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [(Emp_Entity::class)],version = 1)
abstract class AppDb : RoomDatabase()
{
    abstract fun empDao(): Emp_Dao
}