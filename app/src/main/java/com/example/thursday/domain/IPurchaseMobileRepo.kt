package com.example.thursday.domain

interface IPurchaseMobileRepo {
    suspend fun getPurchasedMobileDomainModel():MobileDomainModel
}