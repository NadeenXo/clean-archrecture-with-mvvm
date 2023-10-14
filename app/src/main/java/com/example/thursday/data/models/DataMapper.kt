package com.example.thursday.data.models

import com.example.thursday.domain.models.MobileDomainModel

fun MobileDataModel.toDomainModel(): MobileDomainModel {
    return MobileDomainModel(
        brandName = brandName ?: "unknown",
        brandType = brandType!!
    )
}