package com.shiftkey.codingchallenge.domain

import androidx.compose.ui.graphics.Color
import com.shiftkey.codingchallenge.data.LocalizedSpecialtyDTO
import com.shiftkey.codingchallenge.data.SpecialtyDTO

internal data class LocalizedSpecialty(
    val name: String,
    val abbreviation: String,
    val specialty: Specialty
) {
    constructor(dto: LocalizedSpecialtyDTO) : this(
        name = dto.name,
        abbreviation = dto.abbreviation,
        specialty = Specialty(
            dto.specialty
        )
    )
}

internal data class Specialty(
    val name: String,
    val abbreviation: String,
    val color: Color,
) {
    constructor(dto: SpecialtyDTO) : this(
        name = dto.name,
        abbreviation = dto.abbreviation,
        color = dto.color.toComposeColor(),
    )
}
