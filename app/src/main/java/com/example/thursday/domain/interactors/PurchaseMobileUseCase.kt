package com.example.thursday.domain.interactors

import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.util.Resource
import javax.inject.Inject

class PurchaseMobileUseCase @Inject constructor(private val purchaseMobileRepo: IPurchaseMobileRepo) {
    suspend fun getPurchasedMobileDomainModel() = purchaseMobileRepo.getPurchasedMobileDomainModel()
    suspend fun execute(brandName: String): Resource<String> {
        if (brandName != "i" || brandName != "s") {
            return Resource.NotFoundError("not valid name", 404)
        }
        return purchaseMobileRepo.getBrandName(brandName)
    }
}