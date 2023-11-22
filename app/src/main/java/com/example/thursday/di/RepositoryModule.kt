package com.example.thursday.di

import com.example.thursday.data.RepoImp
import com.example.thursday.domain.repositories.IPurchaseMobileRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule {
//    //imp type we want to inject in the constructor
//    @Binds
//    @Singleton
//    abstract fun bindRepository(repoImp: RepoImp): IPurchaseMobileRepo
//}