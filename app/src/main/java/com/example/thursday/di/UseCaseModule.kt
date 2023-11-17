package com.example.thursday.di

import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//abstract class UseCaseModule {
//    @Binds
//    @Singleton
//    abstract fun bindUseCase(purchaseMobileUseCase: PurchaseMobileUseCase): PurchaseMobileUseCase
//
//}

object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(repoImp: IPurchaseMobileRepo): PurchaseMobileUseCase {
        return PurchaseMobileUseCase(repoImp)
    }
}