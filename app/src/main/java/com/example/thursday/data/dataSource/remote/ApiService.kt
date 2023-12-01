package com.example.thursday.data.dataSource.remote

import com.example.thursday.data.models.MobileDataModel
import retrofit2.http.GET

interface ApiService {
    companion object {
        private const val GET_MOBILE_DETAILS_QUERY = "/mobile/1/details"
    }

    @GET(GET_MOBILE_DETAILS_QUERY)
    fun getMobileDataModel(): MobileDataModel
}