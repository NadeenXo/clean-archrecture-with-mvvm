package com.example.thursday.data

import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.ApiService
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.data.models.toDomainModel
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.domain.models.MobileDomainModel
import javax.inject.Inject

//if i have inject constructor we can use @binds .. we dont need @provides
class RepoImp @Inject constructor(private val mobileRemoteDataSource: MobileRemoteDataSource, private val mobileLocalDataSource: MobileLocalDataSource) : IPurchaseMobileRepo {
    override suspend fun getPurchasedMobileDomainModel(): MobileDomainModel {
        return mobileRemoteDataSource.getMobileDataModel().toDomainModel()
    }
}