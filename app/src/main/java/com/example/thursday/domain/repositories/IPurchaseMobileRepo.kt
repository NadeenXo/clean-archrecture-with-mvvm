package com.example.thursday.domain.repositories

import android.net.http.NetworkException
import com.example.thursday.domain.models.MobileDomainModel
import com.example.thursday.util.Resource

interface IPurchaseMobileRepo {
    suspend fun getPurchasedMobileDomainModel(): MobileDomainModel
    suspend fun getBrandName(brandName:String):Resource<Unit>
}