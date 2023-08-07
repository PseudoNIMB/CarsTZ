package com.example.carstz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carstz.data.entity.Car
import ru.pseudonimb.carstz.R
import ru.pseudonimb.carstz.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Car>()
    var onItemClick : ((Car) -> Unit)? = null
    class CarHolder(car: View) : RecyclerView.ViewHolder(car) {
        val binding = CarItemBinding.bind(car)
        fun bind(car: Car) = with(binding){
            im.setImageResource(car.imageId)
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
        val car = carList[position]
        holder.bind(carList[position])

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(car)

        }

    }
    fun addCar(car: Car){
        carList.add(car)
        notifyDataSetChanged()
    }
}


