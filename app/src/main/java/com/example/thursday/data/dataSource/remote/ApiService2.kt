package com.example.thursday.data.dataSource.remote

import com.example.thursday.data.dataSource.IMobileDataSource
import com.example.thursday.data.models.MobileDataModel
import retrofit2.http.GET

interface ApiService2 : IMobileDataSource {
    companion object {
        private const val GET_MOBILE_DETAILS_QUERY2 = "/mobile/2/details"
    }

    @GET(GET_MOBILE_DETAILS_QUERY2)
    override fun getMobileDataModel2(): MobileDataModel
}