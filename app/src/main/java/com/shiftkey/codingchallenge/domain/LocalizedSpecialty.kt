package com.shiftkey.codingchallenge.domain

import android.os.Parcelable
import com.shiftkey.codingchallenge.data.LocalizedSpecialtyDTO
import com.shiftkey.codingchallenge.data.SpecialtyDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class LocalizedSpecialty(
    val name: String,
    val abbreviation: String,
    val specialty: Specialty
) : Parcelable {
    constructor(dto: LocalizedSpecialtyDTO) : this(
        name = dto.name,
        abbreviation = dto.abbreviation,
        specialty = Specialty(
            dto.specialty
        )
    )
}

@Parcelize
internal data class Specialty(
    val name: String,
    val abbreviation: String,
    val color: String,
) : Parcelable {
    constructor(dto: SpecialtyDTO) : this(
        name = dto.name,
        abbreviation = dto.abbreviation,
        color = dto.color,
    )
}
