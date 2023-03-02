package com.carfax.assignment.ui.home.adapter

import android.Manifest.permission.CALL_PHONE
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.carfax.assignment.core.utils.Constants.REQUEST_PHONE_CALL
import com.carfax.assignment.data.model.CarRemoteModel
import com.carfax.assignment.databinding.VehicleItemBinding

class HomeAdapter(private val listener: InteractionListener,val item: List<CarRemoteModel>) :
    RecyclerView.Adapter<HomeAdapter.MainViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
        val listItemBinding = VehicleItemBinding.inflate(view, parent, false)
        context = parent.context
        return MainViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return this.item.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentData = this.item[position]
        holder.bind(currentData)

        startCall(item[position].dealer?.phone.toString(), holder.binding.buttonItem)

        holder.itemView.setOnClickListener {
            listener.onClick(item[position])
        }
    }

    private fun startCall(phoneNumber: String, button: Button) {
        button.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(CALL_PHONE),
                    REQUEST_PHONE_CALL
                )
            } else {
                val dialIntent = Intent(Intent.ACTION_CALL)
                dialIntent.data = Uri.parse("tel:$phoneNumber")
                context.startActivity(dialIntent)
            }
        }
    }

    inner class MainViewHolder(val binding: VehicleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listItem: CarRemoteModel) {
            binding.item = listItem
        }
    }
}


interface InteractionListener {
    fun onClick(item: CarRemoteModel)
}
