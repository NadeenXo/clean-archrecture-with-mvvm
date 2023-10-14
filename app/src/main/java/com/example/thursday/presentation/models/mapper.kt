package com.example.thursday.presentation.models

import com.example.thursday.domain.MobileDomainModel

fun MobileDomainModel.toUiModel(): MobileUiModel {
    return MobileUiModel(
        brandName = this.brandType
    )
}