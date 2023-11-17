package com.example.thursday.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.presentation.models.MobileUiModel
import com.example.thursday.presentation.models.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseMobileViewModel @Inject constructor
    (private val purchaseMobileUseCase: PurchaseMobileUseCase) : ViewModel() {

    private val _mobileBrand = MutableLiveData<MobileUiModel>()
    val mobileBrand: LiveData<MobileUiModel> = _mobileBrand
    fun getMobileBrand() {
        viewModelScope.launch {
            _mobileBrand.value = purchaseMobileUseCase.getPurchasedMobileDomainModel().toUiModel()
        }
    }
}