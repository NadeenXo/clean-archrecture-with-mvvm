package com.example.thursday.domain.interactors

import com.example.thursday.domain.repositories.IPurchaseMobileRepo

class PurchaseMobileUseCase(private val purchaseMobileRepo: IPurchaseMobileRepo) {

//    suspend fun getPurchasedMobileDomainModel(): MobileDomainModel {
//        return purchaseMobileRepo.getPurchasedMobileDomainModel()
//    }
    suspend fun getPurchasedMobileDomainModel() = purchaseMobileRepo.getPurchasedMobileDomainModel()

}