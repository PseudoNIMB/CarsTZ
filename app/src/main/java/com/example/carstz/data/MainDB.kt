package com.example.carstz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carstz.data.dao.DAO
import com.example.carstz.data.entity.Car


@Database (entities = [Car::class], version = 1, exportSchema = true)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): DAO

    companion object{
        fun getDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "car.db"
            ).build()
        }
    }
}