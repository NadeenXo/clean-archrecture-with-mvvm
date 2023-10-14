package com.example.thursday.data.models

import com.example.thursday.domain.MobileDomainModel

fun MobileDataModel.toDomainModel(): MobileDomainModel {
    return MobileDomainModel(
        brandType = this.brandType!!
    )
}