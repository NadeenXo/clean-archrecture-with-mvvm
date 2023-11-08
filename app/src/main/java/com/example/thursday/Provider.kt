package com.example.thursday

import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.domain.repositories.IPurchaseMobileRepo

class Provider(
    private val userRepository: IPurchaseMobileRepo,
    private val useCase: PurchaseMobileUseCase
) {
//    private val userRepository: IPurchaseMobileRepo = RepoImp(MobileRemoteDataSource(), MobileLocalDataSource())
//    private val useCase: PurchaseMobileUseCase = PurchaseMobileUseCase(userRepository)
//    val purchaseViewModelFactory = PurchaseViewModelFactory(useCase)
}