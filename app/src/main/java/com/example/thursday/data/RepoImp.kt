package com.example.thursday.data

import com.example.thursday.data.dataSource.IMobileDataSource
import com.example.thursday.data.models.toDomainModel
import com.example.thursday.domain.IPurchaseMobileRepo
import com.example.thursday.domain.MobileDomainModel

class RepoImp(private val mobileDataSource:IMobileDataSource):IPurchaseMobileRepo {
    override suspend fun getPurchasedMobileDomainModel(): MobileDomainModel {
       return mobileDataSource.getMobileDataModel().toDomainModel()
    }
}