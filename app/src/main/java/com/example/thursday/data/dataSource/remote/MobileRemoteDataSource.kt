package com.example.thursday.data.dataSource.remote

import com.example.thursday.data.dataSource.IMobileDataSource
import com.example.thursday.data.models.MobileDataModel
import javax.inject.Inject

class MobileRemoteDataSource @Inject constructor() : IMobileDataSource {
    override fun getMobileDataModel(): MobileDataModel {
        return MobileDataModel("", 's')
    }

    override fun getMobileDataModel2(): MobileDataModel {
        return MobileDataModel("", 'i')
    }
}