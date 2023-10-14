package com.example.thursday.presentation.models

import com.example.thursday.R
import com.example.thursday.domain.models.MobileDomainModel

fun MobileDomainModel.toUiModel(): MobileUiModel {
    return MobileUiModel(
        brandType = mapLetterToBrand(this.brandType)
    )
}

fun mapLetterToBrand(brandType: Char): Int {
    return when (brandType) {
        // if  (brandType == BrandType.IPHONE.char)  return  R.string.iphone
        BrandType.IPHONE.char -> R.string.iphone
        BrandType.SAMSUNG.char -> R.string.samsung
        else -> R.string.iphone
    }

}
