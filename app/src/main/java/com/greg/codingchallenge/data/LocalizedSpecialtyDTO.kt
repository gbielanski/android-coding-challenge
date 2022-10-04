package com.greg.codingchallenge.data

import androidx.annotation.Keep

@Keep
internal data class LocalizedSpecialtyDTO(
    val name: String,
    val abbreviation: String,
    val specialty: SpecialtyDTO,
)

@Keep
internal data class SpecialtyDTO(
    val name: String,
    val color: String,
    val abbreviation: String,
)
