package com.latifaumunyana.electronicdevices.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.latifaumunyana.electronicdevices.databinding.ActivityDetailsBinding
import com.latifaumunyana.electronicdevices.model.Details
import com.latifaumunyana.electronicdevices.viewModel.DevicesViewModel

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    val deviceDetailViewModel: DevicesViewModel by viewModels()

    var deviceIds = 0
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = binding.progressBar

        val extra = intent.extras
        if (extra != null){
        val deviceId = intent.getIntExtra("id",0)
        if (deviceId != null) {
            progressBar.visibility = View.VISIBLE
            deviceDetailViewModel.fetchDeviceDetails(deviceId)
        } else {
            Toast.makeText(this, "Device id is not found", Toast.LENGTH_SHORT).show()
        }
    }
        else{
            Toast.makeText(this, "Device not found", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onResume() {
        super.onResume()
        deviceDetailViewModel.detailLiveData.observe(this, Observer { detail ->

            progressBar.visibility = View.GONE
            displayDetails(detail)
        })
        deviceDetailViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(this, "Message: $error", Toast.LENGTH_LONG).show()
        })
    }

fun displayDetails(detail: Details) {
//        val detailsAdapter = DeviceDetailsAdapter(detail, this)
//        binding.rvDetails.adapter = detailsAdapter

    binding.tvName.text = detail?.color ?: "No data"
    binding.tvDescription.text = detail.description ?: "No data"
    binding.textView.text = detail.price.toString()
    binding.tvCapacity.text = detail.capacity
    }
}
