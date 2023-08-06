package com.example.carstz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Item::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): DAO

    companion object{
        fun getDB(context: Context): MainDB{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "car.db"
            ).build()
        }
    }
}