package com.shiftkey.codingchallenge.domain

import android.os.Parcelable
import com.shiftkey.codingchallenge.data.FacilityTypeDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class FacilityType(
    val name: String,
    val color: String,
) : Parcelable {
    constructor(dto: FacilityTypeDTO) : this(
        dto.name,
        dto.color
    )
}
