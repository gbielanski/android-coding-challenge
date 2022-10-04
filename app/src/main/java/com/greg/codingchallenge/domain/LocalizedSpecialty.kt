package com.greg.codingchallenge.domain

import android.os.Parcelable
import com.greg.codingchallenge.data.LocalizedSpecialtyDTO
import com.greg.codingchallenge.data.SpecialtyDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class LocalizedSpecialty(
    val name: String,
    val abbreviation: String,
    val specialty: Specialty
) : Parcelable

internal fun localizedSpecialtyOf(dto: LocalizedSpecialtyDTO) = LocalizedSpecialty(
    name = dto.name,
    abbreviation = dto.abbreviation,
    specialty = specialtyOf(
        dto.specialty
    )
)

@Parcelize
internal data class Specialty(
    val name: String,
    val abbreviation: String,
    val color: String,
) : Parcelable

internal fun specialtyOf(dto: SpecialtyDTO) = Specialty(
    name = dto.name,
    abbreviation = dto.abbreviation,
    color = dto.color,
)
