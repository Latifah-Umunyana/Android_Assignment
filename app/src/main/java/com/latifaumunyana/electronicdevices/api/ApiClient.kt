package com.latifaumunyana.electronicdevices.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit
        .Builder()
        .baseUrl("https://api.restful-api.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T{
        return retrofit.create(apiInterface)
    }
}