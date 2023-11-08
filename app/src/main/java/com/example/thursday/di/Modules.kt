package com.example.thursday.di

import com.example.thursday.Provider
import com.example.thursday.data.RepoImp
import com.example.thursday.data.dataSource.local.MobileLocalDataSource
import com.example.thursday.data.dataSource.remote.ApiService
import com.example.thursday.data.dataSource.remote.MobileRemoteDataSource
import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import com.example.thursday.presentation.ui.PurchaseMobileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {
    single { MobileRemoteDataSource() }
    single { MobileLocalDataSource() }


    single<IPurchaseMobileRepo> {
        RepoImp(get(), get()) // Get the required data sources from Koin
    }

    // Define the use case
    single {
        PurchaseMobileUseCase(get()) // Get the repository from Koin
    }

    // Define the Provider class and provide the dependencies
    single { Provider(get(), get()) }
}

val viewModels = module {
    viewModel { PurchaseMobileViewModel(purchaseMobileUseCase = get()) }
}
val networkModule = module {
    val BASE_URL = ""
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

