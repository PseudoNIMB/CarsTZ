package com.example.carstz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carstz.data.MainDB
import com.example.carstz.data.entity.Item
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
                adapter.addCar(it.data?.getSerializableExtra("car") as Item)
            }
        }
    }

    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        adapter = CarAdapter()
        rcView.adapter = adapter


        val db = MainDB.getDB(this@MainActivity)
        db.getDao().getAllItems().asLiveData().observe(this@MainActivity){list ->
            list.forEach{ _ ->
                adapter.addCar(car = Item
                    (id = 0, brand = "", model = "", engine = "", transmission = "", price = ""))
                adapter
            }
        }

        buttonAdd.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}