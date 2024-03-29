package com.example.thursday.data

import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.data.models.toDomainModel
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.domain.models.MobileDomainModel

class RepoImp(private val mobileDataSource: MobileRemoteDataSource) : IPurchaseMobileRepo {
    override suspend fun getPurchasedMobileDomainModel(): MobileDomainModel {
        return mobileDataSource.getMobileDataModel().toDomainModel()
    }
}