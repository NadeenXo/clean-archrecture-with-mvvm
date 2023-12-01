package com.example.thursday.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thursday.domain.interactors.PurchaseMobileUseCase
import com.example.thursday.presentation.models.MobileUiModel
import com.example.thursday.presentation.models.toUiModel
import com.example.thursday.util.Resource
import com.example.thursday.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseMobileViewModel @Inject constructor
    (private val purchaseMobileUseCase: PurchaseMobileUseCase) : ViewModel() {

    private val _mobileBrand = MutableLiveData<MobileUiModel>()
    val mobileBrand: LiveData<MobileUiModel> = _mobileBrand

    private val _brandName = MutableStateFlow("")
    val brandName: StateFlow<String> = _brandName

    private var _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _screenState =
        MutableStateFlow<ScreenState>(ScreenState.Success("Initial success state"))
    val screenState: StateFlow<ScreenState> = _screenState

    fun getMobileBrand() {
        viewModelScope.launch {
            _mobileBrand.value = purchaseMobileUseCase.getPurchasedMobileDomainModel().toUiModel()
        }
    }

    fun getBrandName() {
        viewModelScope.launch {
            val result = purchaseMobileUseCase.execute(brandName.value)
            when (result) {
                is Resource.Success -> {
                    _screenState.value = ScreenState.Success(result.data.toString())
                    _brandName.value = result.data.toString()
                }

                is Resource.NetworkError -> {
                    _screenState.value = ScreenState.NetworkError(result.message.toString())
                }

                is Resource.NotFoundError -> {
                    _screenState.value = ScreenState.NotFoundError(result.message.toString())
                }
            }
        }
    }
}