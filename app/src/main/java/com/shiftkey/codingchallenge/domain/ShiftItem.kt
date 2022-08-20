package com.shiftkey.codingchallenge.domain

import com.shiftkey.codingchallenge.data.ShiftItemDTO

internal data class ShiftItem(
    val shiftId: Long,
    val startTime: String,
    val endTime: String,
    val isPremiumRate: Boolean,
    val isCovid: Boolean,
    val kind: String,
    val skill: Skill,
    val facilityType: FacilityType,
    val localizedSpecialty: LocalizedSpecialty
) {
    constructor(dto: ShiftItemDTO) : this(
        shiftId = dto.shiftId,
        startTime = dto.startTime,
        endTime = dto.endTime,
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