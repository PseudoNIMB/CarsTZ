package com.example.carstz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carstz.data.entity.Item
import com.example.carstz.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Item>()
    class CarHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)

        fun bind(car: Item) = with(binding){

            //im.setImageResource(imageId)
            tvTitle.text = car.brand + " " + car.model + " " + car.engine + " " + car.transmission + " " + car.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.car_item, parent, false)

        return CarHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])

    }

    fun addCar(car: Item){
        carList.add(car)
        notifyDataSetChanged()
    }
}