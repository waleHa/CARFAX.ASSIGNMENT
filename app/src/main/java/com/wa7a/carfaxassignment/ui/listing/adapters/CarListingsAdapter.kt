package com.wa7a.carfaxassignment.ui.listing.adapters

import android.Manifest.permission.CALL_PHONE
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.carfaxassignment.data.model.ListingsRemoteModel
import com.wa7a.carfaxassignment.databinding.VehicleItemBinding
import com.wa7a.carfaxassignment.utils.Constants.REQUEST_PHONE_CALL


class CarListingsAdapter(private val listener: InteractionListener) :
    RecyclerView.Adapter<CarListingsAdapter.MainViewHolder>() {
    private var item = listOf<ListingsRemoteModel?>()
    private lateinit var context: Context

    fun setContentList(data: List<ListingsRemoteModel?>) {
        this.item = data
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val binding: VehicleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listItem: ListingsRemoteModel?) {
            if (listItem != null) {
                binding.item = listItem
            }
        }
    }

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

        holder.binding.buttonItem.setOnClickListener {
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
                startCall(requireNotNull(item[position]?.dealer?.phone))
            }
        }
        holder.itemView.setOnClickListener {
            listener.onClick(requireNotNull(item[position]))
        }
    }

    private fun startCall(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_CALL)
        dialIntent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(dialIntent)
    }
}


interface InteractionListener {
    fun onClick(item: ListingsRemoteModel)
}
