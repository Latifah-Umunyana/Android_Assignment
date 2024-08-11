package com.latifaumunyana.electronicdevices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.latifaumunyana.electronicdevices.R
import com.latifaumunyana.electronicdevices.databinding.ActivityMainBinding
import com.latifaumunyana.electronicdevices.model.Device
import com.latifaumunyana.electronicdevices.viewModel.DevicesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val devicesViewModel: DevicesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        devicesViewModel.fetchDevices()
        binding.rvDevices.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        devicesViewModel.deviceLiveData.observe(this, Observer { deviceList ->
            displayDevices(deviceList)
        })
        devicesViewModel.errorLiveData.observe(this, Observer{error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }

    fun displayDevices(devices: List<Device>){
        val deviceAdapter = DevicesAdapter(devices, this)
        binding.rvDevices.adapter = deviceAdapter
    }
}