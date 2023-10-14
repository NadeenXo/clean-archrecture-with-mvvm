package com.example.thursday.domain

class PurchaseMobileUseCase (private val purchaseMobileRepo: IPurchaseMobileRepo){
    suspend fun getPurchasedMobileDomainModel():MobileDomainModel{
        return purchaseMobileRepo.getPurchasedMobileDomainModel()
    }

}