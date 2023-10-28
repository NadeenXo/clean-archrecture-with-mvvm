package com.example.thursday.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thursday.domain.interactors.PurchaseMobileUseCase

class PurchaseViewModelFactory(private val purchaseMobileUseCase: PurchaseMobileUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PurchaseMobileViewModel::class.java)) {
            return PurchaseMobileViewModel(purchaseMobileUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}