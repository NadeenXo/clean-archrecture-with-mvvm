package com.example.thursday.data.dataSource.remote

import com.example.thursday.data.dataSource.IMobileDataSource
import com.example.thursday.data.models.MobileDataModel

class MobileRemoteDataSource : IMobileDataSource {
    override fun getMobileDataModel(): MobileDataModel {
        return MobileDataModel("", 's')
    }
}