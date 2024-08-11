package com.latifaumunyana.electronicdevices.api

import android.devicelock.DeviceId
import com.latifaumunyana.electronicdevices.model.Details
import com.latifaumunyana.electronicdevices.model.Device
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DevicesApiInterface {
    @GET("/objects")
    suspend fun fetchDevices(): Response<List<Device>>

    @GET ("/objects/{id}")
    suspend fun fetchDeviceDetails(@Path("id") id: Int): Response<Details>

}