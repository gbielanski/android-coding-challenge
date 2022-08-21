package com.shiftkey.codingchallenge.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class ShiftItemDTO(
    @SerializedName("shift_id")
    val shiftId: Long,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("end_time")
    val endTime: String,
    @SerializedName("normalized_start_date_time")
    val normalizedStartTime: String,
    @SerializedName("normalized_end_date_time")
    val normalizedEndTime: String,
    @SerializedName("premium_rate")
    val isPremiumRate: Boolean,
    @SerializedName("covid")
    val isCovid: Boolean,
    @SerializedName("shift_kind")
    val kind: String,
    @SerializedName("skill")
    val skill: SkillDTO,
    @SerializedName("facility_type")
    val facility: FacilityTypeDTO,
    @SerializedName("localized_specialty")
    val localizedSpecialty: LocalizedSpecialtyDTO,
)
