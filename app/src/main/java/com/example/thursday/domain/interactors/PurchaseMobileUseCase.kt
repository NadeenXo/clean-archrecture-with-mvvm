package com.example.thursday.domain.interactors

import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import javax.inject.Inject

class PurchaseMobileUseCase @Inject constructor(private val purchaseMobileRepo: IPurchaseMobileRepo) {
    suspend fun getPurchasedMobileDomainModel() = purchaseMobileRepo.getPurchasedMobileDomainModel()

}