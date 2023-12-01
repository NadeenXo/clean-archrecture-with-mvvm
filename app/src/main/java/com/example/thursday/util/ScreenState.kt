package com.example.thursday.util

sealed class ScreenState {
    data class Success(val data: String) : ScreenState()
    data class NotFoundError(val message: String) : ScreenState()
    data class NetworkError(val message: String) : ScreenState()

}
