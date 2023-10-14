package com.example.thursday.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {


        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json;charset=UTF-8")
//            .addHeader("Authorization", "Bearer $accessToken")
            .build()

        return chain.proceed(request)
    }
}