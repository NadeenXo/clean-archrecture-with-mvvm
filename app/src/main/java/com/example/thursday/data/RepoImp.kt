package com.example.thursday.data

import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.data.models.toDomainModel
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.domain.models.MobileDomainModel
import com.example.thursday.util.Resource
import javax.inject.Inject
import kotlin.random.Random

class RepoImp @Inject constructor(
    private val mobileRemoteDataSource: MobileRemoteDataSource,
    private val mobileLocalDataSource: MobileLocalDataSource
) : IPurchaseMobileRepo {
    override suspend fun getPurchasedMobileDomainModel(): MobileDomainModel {
        return mobileRemoteDataSource.getMobileDataModel().toDomainModel()
    }

    override suspend fun getBrandName(brandName: String): Resource<Unit> {
        //network call delay
        return if (Random.nextBoolean()) {
            Resource.Success(Unit)
        } else {
            if (Random.nextBoolean()) {
                Resource.NotFoundError("Mobile not found", 404)
            } else {
                Resource.NetworkError("Network error", 404)
            }
        }
    }
}