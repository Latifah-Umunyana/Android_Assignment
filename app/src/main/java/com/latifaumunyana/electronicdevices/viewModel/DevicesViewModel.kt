package com.latifaumunyana.electronicdevices.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latifaumunyana.electronicdevices.model.Device
import com.latifaumunyana.electronicdevices.repository.DevicesRepository
import kotlinx.coroutines.launch

class DevicesViewModel: ViewModel() {
    val deviceRepository = DevicesRepository()
    val errorLiveData = MutableLiveData<String>()
    val deviceLiveData = MutableLiveData<List<Device>>()
    val detailLiveData = MutableLiveData<Device>()

    fun fetchDevices(){
        viewModelScope.launch {
            val response = deviceRepository.fetchDevice()
            if (response.isSuccessful){
                deviceLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun fetchDeviceDetails(id: Int) {
        viewModelScope.launch {
            val response = deviceRepository.fetchDeviceDetails(id)
            if (response.isSuccessful) {
                detailLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}