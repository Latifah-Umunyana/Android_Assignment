package com.latifaumunyana.electronicdevices.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latifaumunyana.electronicdevices.databinding.DevicesListItemBinding
import com.latifaumunyana.electronicdevices.model.Device

class DevicesAdapter(var deviceList: List<Device>, val context: Context): RecyclerView.Adapter<DevicesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesViewHolder {
        val binding = DevicesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DevicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DevicesViewHolder, position: Int) {
       val device = deviceList[position]
        holder.binding.apply {
            tvName.text = device.name
            cvDevice.setOnClickListener{
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("id", device.id.toInt())
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }
}

class DevicesViewHolder(var binding: DevicesListItemBinding): RecyclerView.ViewHolder(binding.root)