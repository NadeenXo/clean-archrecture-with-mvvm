package com.example.thursday.util

sealed class Resource<T>(
    val data: T?, val message: String? = null, val errorCode: Int? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class NetworkError<T>(message: String, errorCode: Int, data: T? = null) :
        Resource<T>(data, message, errorCode)

    class NotFoundError<T>(message: String, errorCode: Int, data: T? = null) :
        Resource<T>(data, message, errorCode)
}

