package com.example.thursday

import com.example.thursday.data.RepoImp
import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.presentation.ui.PurchaseViewModelFactory

class Provider {
    private val userRepository: IPurchaseMobileRepo = RepoImp(MobileRemoteDataSource(), MobileLocalDataSource())
    private val useCase: PurchaseMobileUseCase = PurchaseMobileUseCase(userRepository)
    val purchaseViewModelFactory = PurchaseViewModelFactory(useCase)
}