package com.latifaumunyana.electronicdevices.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.latifaumunyana.electronicdevices.databinding.ActivityDetailsBinding
import com.latifaumunyana.electronicdevices.model.Details
import com.latifaumunyana.electronicdevices.viewModel.DevicesViewModel
import java.util.Objects

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    val deviceDetailViewModel: DevicesViewModel by viewModels()

    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = binding.progressBar

        var deviceId = intent.getIntExtra("id",0)
        if (deviceId != null) {
            progressBar.visibility = View.VISIBLE
            deviceDetailViewModel.fetchDeviceDetails(deviceId)
        }

        else {
            Toast.makeText(this, "Device id is not found", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onResume() {
        super.onResume()
        deviceDetailViewModel.detailLiveData.observe(this, Observer { detail ->
            progressBar.visibility = View.GONE
            val detailsLowerCase = detail.data
            Log.d("detailsList","List: $detail")
            displayDetails(detailsLowerCase)
        })
        deviceDetailViewModel.errorLiveData.observe(this, Observer { error ->
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Message: $error", Toast.LENGTH_LONG).show()
        })
    }

    fun displayDetails(detail: Details) {
        Log.d("DetailsActivity", "Detail: $detail")
        binding.tvName.text = (detail.color)

        if (detail.color != null){
            binding.tvName.visibility = View.VISIBLE
            binding.tvColor.visibility = View.VISIBLE
        }

        if (detail.color != null){
            binding.tvColor.visibility = View.VISIBLE
            binding.tvColor.visibility = View.VISIBLE
        }
        if (detail.price != null){
            binding.tvPriceTitle.visibility = View.VISIBLE
            binding.tvPriceChild.visibility = View.VISIBLE
            binding.tvPriceChild.text = detail.price.toString()
        }
//
        if (detail.Description != null){
            binding.tvDescriptionTitle.visibility = View.VISIBLE
            binding.tvDescription.visibility = View.VISIBLE
        }

        if (detail.capacity != null){
            binding.tvCapacity.visibility = View.VISIBLE
            binding.tvCapacity.visibility = View.VISIBLE
        }

        if (detail.year != null){
            binding.tvYearTitle.visibility = View.VISIBLE
            binding.tvYear.visibility = View.VISIBLE
        }

        if (detail.year != null){
            binding.tvYearTitle.visibility = View.VISIBLE
            binding.tvYear.visibility = View.VISIBLE
        }

        if (detail.capacity != null){
            binding.tvCapacityTitle.visibility = View.VISIBLE
            binding.tvCapacity.visibility = View.VISIBLE
        }

        if (detail.caseSize != null){
            binding.tvCaseSizeTitle.visibility = View.VISIBLE
            binding.tvCaseSize.visibility = View.VISIBLE
        }
        if (detail.generation != null){
            binding.tvGenerationTitle.visibility = View.VISIBLE
            binding.tvGeneration.visibility = View.VISIBLE
        }
        if (detail.hardDisk != null){
            binding.tvDisk.visibility = View.VISIBLE
            binding.tvHardDisk.visibility = View.VISIBLE
        }

    binding.tvDescription.text = detail.Description
    binding.tvCapacity.text = detail.capacity
    binding.tvYear.text = detail.year
    binding.tvCaseSize.text = detail.caseSize
    binding.tvGeneration.text = detail.generation
    binding.tvCpuModel.text = detail.cpuModel
    binding.tvHardDisk.text = detail.hardDisk
    binding.tvScreenSize.text = detail.screenSize
    }
}