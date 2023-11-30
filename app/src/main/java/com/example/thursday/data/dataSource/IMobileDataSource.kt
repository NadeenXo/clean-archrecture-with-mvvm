package com.example.thursday.data.dataSource

import com.example.thursday.data.models.MobileDataModel

interface IMobileDataSource {
    fun getMobileDataModel(): MobileDataModel
    fun getMobileDataModel2(): MobileDataModel
}