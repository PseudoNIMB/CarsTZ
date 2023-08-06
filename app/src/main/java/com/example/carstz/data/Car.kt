package com.example.carstz.data

import java.io.Serializable

data class Car(val imageId: Int,
               val title: String,
               val desc: String,
               val engine: String,
               val trans: String,
               val price: String
): Serializable
