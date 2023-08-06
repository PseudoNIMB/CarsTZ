package com.example.carstz.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.carstz.data.entity.Item
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