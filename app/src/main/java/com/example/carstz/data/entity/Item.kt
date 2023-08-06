package com.example.carstz.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "car.db")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "engine") val engine: String,
    @ColumnInfo(name = "transmission") val transmission: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "imageId") val imageId: Int
) : Serializable
