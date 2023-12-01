package com.example.thursday.data.dataSource.remote

import com.example.thursday.data.models.MobileDataModel
import javax.inject.Inject

class MobileRemoteDataSource @Inject constructor() : ApiService {
    override fun getMobileDataModel(): MobileDataModel {
        return MobileDataModel("", 's')
    }
}