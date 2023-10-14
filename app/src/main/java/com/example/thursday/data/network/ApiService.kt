package com.example.thursday.data.network

import com.example.thursday.data.models.MobileDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val GET_BRAND_NAME_QUERY = "/mobile/{id}/details"

interface ApiService {
    @GET(GET_BRAND_NAME_QUERY)
    fun getBrandName(@Path("id") id: Int): Response<MobileDataModel>
}