package com.example.carstz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carstz.data.MainDB
import com.example.carstz.data.entity.Car
import ru.pseudonimb.carstz.R
import ru.pseudonimb.carstz.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.audia4
    private val imageIdList = listOf(
        R.drawable.audia4,
        R.drawable.audia6,
        R.drawable.audia8,
        R.drawable.bmwx3,
        R.drawable.bmwx5,
        R.drawable.bmwx6,
        R.drawable.volkswagengolf,
        R.drawable.volkswagenpassat,
        R.drawable.volkswagenpolo,
        R.drawable.audiq3,
        R.drawable.audiq5,
        R.drawable.audiq7
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bNext.setOnClickListener{
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val db = MainDB.getDB(this@EditActivity)
            val car = Car(null,
                edBrand.text.toString(),
                edModel.text.toString(),
                edEngine.text.toString(),
                edTrans.text.toString(),
                edPrice.text.toString(),
                imageId
            )

            Thread{
                db.getDao().insertItem(car)
            }.start()
            val editIntent = Intent().apply{
                putExtra("car", car)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}