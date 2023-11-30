package com.example.thursday.di

import com.example.thursday.data.RepoImp
import com.example.thursday.data.dataSource.IMobileDataSource
import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.ApiService
import com.example.thursday.data.dataSource.remote.ApiService2
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {
//            val BASE_URL = "https://example.com"

//    solution 1
    @Provides
    @Singleton
    inline fun <reified T> provideApi(): T {
        val BASE_URL = "https://example.com"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
    }
//solution 2
//    add this 2 lines in activity
//        @Inject lateinit var retrofit: Retrofit
//            retrofit.create(myApiService)


//    @Provides
//    @Singleton
//    fun provideRetrofit():Retrofit{
//        val BASE_URL = "https://example.com"
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

//  solution 3
//    @Provides
//    @Singleton
//    fun provideRetrofit():Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    val apiService1:ApiService by lazy {
//        provideRetrofit().create(ApiService::class.java)
//    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return provideApi()
    }

    @Provides
    @Singleton
    fun provideApiService2(): ApiService2 {
        return provideApi()
    }

    @Provides
    @Singleton
    fun provideRepository(
        mobileRemoteDataSource: MobileRemoteDataSource,
        mobileLocalDataSource: MobileLocalDataSource
    ): IPurchaseMobileRepo {
        return RepoImp(mobileRemoteDataSource, mobileLocalDataSource)
    }

//    @Provides
//    fun provideUseCase(repoImp: IPurchaseMobileRepo): PurchaseMobileUseCase {
//        return PurchaseMobileUseCase(repoImp)
//    }
}

//The @Provides annotation is used to create and provide instances of dependencies,
// while the @Binds annotation establishes the relationship between an interface and its implementation.
