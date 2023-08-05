package com.example.carstz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carstz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.audia4,
        R.drawable.audia6,
        R.drawable.audia8,
        R.drawable.bmwx3,
        R.drawable.bmwx5,
        R.drawable.bmwx6,
        R.drawable.volkswagengolf,
        R.drawable.volkswagenpassat,
        R.drawable.volkswagenpolo
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter
        buttonAdd.setOnClickListener {
            if (index > 8) index = 0
            val car = Car(imageIdList[index],"Car $index")
            adapter.addCar(car)
            index++
        }
    }
}