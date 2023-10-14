package com.example.thursday.domain.repositories

import com.example.thursday.domain.models.MobileDomainModel

interface IPurchaseMobileRepo {
    suspend fun getPurchasedMobileDomainModel(): MobileDomainModel
}