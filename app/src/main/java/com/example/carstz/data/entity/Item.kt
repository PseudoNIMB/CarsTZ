package com.example.carstz.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity (tableName = "car.db")
data class Item(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "brand") var brand: String,
    @ColumnInfo(name = "model") var model: String,
    @ColumnInfo(name = "engine") var engine: String,
    @ColumnInfo(name = "transmission") var transmission: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "imageId") var imageId: Int
) : Serializable
