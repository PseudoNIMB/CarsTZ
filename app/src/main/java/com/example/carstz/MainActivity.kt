package com.example.carstz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carstz.data.MainDB
import com.example.carstz.data.entity.Car
import com.example.carstz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarAdapter
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        editLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode == RESULT_OK){
                adapter.addCar(it.data?.getSerializableExtra("car") as Car)
            }
        }

        //второй лаунчер для проверки есть ли данные
    }
    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        adapter = CarAdapter()
        rcView.adapter = adapter


        val db = MainDB.getDB(this@MainActivity)
        db.getDao().getAllItems().asLiveData().observe(this@MainActivity){ it ->

            it.forEach{
                adapter.addCar(car = Car
                    (
                    id = it.id,
                    brand = it.brand,
                    model = it.model,
                    engine = it.engine,
                    transmission = it.transmission,
                    price = it.price,
                    imageId = it.imageId))
                adapter.notifyDataSetChanged()
            }
        }

        adapter.onItemClick = {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            adapter.notifyDataSetChanged()
        }

        buttonAdd.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

        }

        buttonFilter.setOnClickListener{

        }
    }
}