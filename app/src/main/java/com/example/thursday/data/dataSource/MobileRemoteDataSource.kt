package com.example.thursday.data.dataSource

import com.example.thursday.data.models.MobileDataModel

class MobileRemoteDataSource :IMobileDataSource{

    override fun getMobileDataModel(): MobileDataModel {
        return MobileDataModel('s')
    }
}