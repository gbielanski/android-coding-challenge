package com.shiftkey.codingchallenge.domain

import androidx.compose.ui.graphics.Color
import com.shiftkey.codingchallenge.data.FacilityTypeDTO

internal data class FacilityType(
    val name: String,
    val color: Color,
) {
    constructor(dto: FacilityTypeDTO) : this(
        dto.name,
        dto.color.toComposeColor()
    )
}
