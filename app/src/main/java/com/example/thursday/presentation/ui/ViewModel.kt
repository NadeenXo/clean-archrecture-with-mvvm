package com.example.thursday.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thursday.domain.PurchaseMobileUseCase
import com.example.thursday.presentation.models.toUiModel
import kotlinx.coroutines.launch

class ViewModel(private val purchaseMobileUseCase: PurchaseMobileUseCase) : ViewModel() {

    private val _mobileBrand = MutableLiveData<String>()
    val mobileBrand: LiveData<String> = _mobileBrand

    fun getMobileBrand() {
        viewModelScope.launch {
            purchaseMobileUseCase.getPurchasedMobileDomainModel().toUiModel()
        }
    }
}