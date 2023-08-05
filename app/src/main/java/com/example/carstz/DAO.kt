package com.example.carstz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {

    //Запись в БД SQLite
    @Insert
    fun insertItem(item: Item)

    //Считывание с БД SQLite
    @Query("SELECT * FROM `car.db`")
    fun getAllItems(): Flow<List<Item>>

}