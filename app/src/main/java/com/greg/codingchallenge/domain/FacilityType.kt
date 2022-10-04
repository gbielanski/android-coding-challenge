package com.greg.codingchallenge.domain

import android.os.Parcelable
import com.greg.codingchallenge.data.FacilityTypeDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class FacilityType(
    val name: String,
    val color: String,
) : Parcelable

internal fun facilityTypeOf(dto: FacilityTypeDTO) = FacilityType(
    dto.name,
    dto.color
)
