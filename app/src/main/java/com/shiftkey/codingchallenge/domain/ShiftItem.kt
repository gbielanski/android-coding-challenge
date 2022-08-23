package com.shiftkey.codingchallenge.domain

import android.os.Parcelable
import com.shiftkey.codingchallenge.data.ShiftItemDTO
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
) : Parcelable {
    constructor(dto: ShiftItemDTO) : this(
        shiftId = dto.shiftId,
        startTime = dto.startTime,
        endTime = dto.endTime,
        normalizedStartTime = dto.normalizedStartTime,
        normalizedEndTime = dto.normalizedEndTime,
        isPremiumRate = dto.isPremiumRate,
        isCovid = dto.isCovid,
        kind = dto.kind,
        skill = Skill(
            dto.skill
        ),
        facilityType = FacilityType(
            dto.facility
        ),
        localizedSpecialty = LocalizedSpecialty(
            dto.localizedSpecialty
        )
    )
}
