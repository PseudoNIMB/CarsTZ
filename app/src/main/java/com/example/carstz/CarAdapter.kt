package com.example.carstz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carstz.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Car>()
    class CarHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)

        fun bind(car: Car) = with(binding){

            im.setImageResource(car.imageId)
            tvTitle.text = car.title + " " + car.desc + " " + car.engine + " " + car.trans + " " + car.price
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

    fun addCar(car: Car){
        carList.add(car)
        notifyDataSetChanged()
    }
}