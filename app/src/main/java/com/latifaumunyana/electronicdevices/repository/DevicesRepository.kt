package com.latifaumunyana.electronicdevices.repository

import com.latifaumunyana.electronicdevices.api.ApiClient
import com.latifaumunyana.electronicdevices.api.DevicesApiInterface
import com.latifaumunyana.electronicdevices.model.Details
import com.latifaumunyana.electronicdevices.model.Device
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DevicesRepository {
    val apiClient  = ApiClient.buildApiClient(DevicesApiInterface::class.java)

    suspend fun fetchDevice(): Response<List<Device>>{
        return withContext(Dispatchers.IO){
            apiClient.fetchDevices()
        }
    }

    suspend fun fetchDeviceDetails(id: Int): Response<Details> {
        return withContext(Dispatchers.IO){
            apiClient.fetchDeviceDetails(id)
        }
    }
}