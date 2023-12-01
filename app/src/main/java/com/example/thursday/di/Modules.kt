package com.example.thursday.di

import com.example.thursday.data.RepoImp
import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.ApiService
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {
    @Provides
    @Singleton
    fun provideApi(): ApiService {
        val BASE_URL = " "
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(mobileRemoteDataSource: MobileRemoteDataSource, mobileLocalDataSource: MobileLocalDataSource): IPurchaseMobileRepo {
        return RepoImp(mobileRemoteDataSource,mobileLocalDataSource)
    }

//    @Provides
//    fun provideUseCase(repoImp: IPurchaseMobileRepo): PurchaseMobileUseCase {
//        return PurchaseMobileUseCase(repoImp)
//    }
}

//The @Provides annotation is used to create and provide instances of dependencies,
// while the @Binds annotation establishes the relationship between an interface and its implementation.
