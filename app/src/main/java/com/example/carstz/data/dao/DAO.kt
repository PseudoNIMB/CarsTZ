package com.example.carstz.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.carstz.data.entity.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {

    //Запись в БД SQLite
    @Insert
    fun insertItem(car: Car)

    //Считывание с БД SQLite
    @Query("SELECT * FROM `car.db`")
    fun getAllItems(): Flow<List<Car>>
}