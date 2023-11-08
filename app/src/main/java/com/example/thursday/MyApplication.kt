package com.example.thursday

import android.app.Application
import com.example.thursday.di.appModules
import com.example.thursday.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(listOf(appModules, viewModels))
        }
    }


}