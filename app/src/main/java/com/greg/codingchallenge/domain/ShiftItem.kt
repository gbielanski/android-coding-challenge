package com.greg.codingchallenge.domain

import android.os.Parcelable
import com.greg.codingchallenge.data.ShiftItemDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ShiftItem(
    val shiftId: Long,
    val startTime: String,
    val endTime: String,
    val normalizedStartTime: String,
    val normalizedEndTime: String,
    val isPremiumRate: Boolean,
    val isCovid: Boolean,
    val kind: String,
    val skill: Skill,
    val facilityType: FacilityType,
    val localizedSpecialty: LocalizedSpecialty
) : Parcelable

internal fun shiftItemOf(dto: ShiftItemDTO): ShiftItem {
    return ShiftItem(
        shiftId = dto.shiftId,
        startTime = dto.startTime,
        endTime = dto.endTime,
        normalizedStartTime = dto.normalizedStartTime,
        normalizedEndTime = dto.normalizedEndTime,
        isPremiumRate = dto.isPremiumRate,
        isCovid = dto.isCovid,
        kind = dto.kind,
        skill = skillOf(
            dto.skill
        ),
        facilityType = facilityTypeOf(
            dto.facility
        ),
        localizedSpecialty = localizedSpecialtyOf(
            dto.localizedSpecialty
        )
    )
}

internal typealias ShiftItemMapper = @JvmSuppressWildcards (dto: ShiftItemDTO) -> ShiftItem
