package com.shiftkey.codingchallenge.data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/*
{
    "shift_id":3466174,
    "start_time":"2022-08-20T11:00:00+00:00",
    "end_time":"2022-08-20T23:00:00+00:00",
    "normalized_start_date_time":"2022-08-20 06:00:00",
    "normalized_end_date_time":"2022-08-20 18:00:00",
    "timezone":"Central",
    "premium_rate":false,
    "covid":false,
    "shift_kind":"Day Shift",
    "within_distance":80,
    "facility_type":{
        "id":8,
        "name":"Skilled Nursing Facility",
        "color":"#AF52DE"
    },
    "skill":{
        "id":2,
        "name":"Long Term Care",
        "color":"#007AFF"
    },
    "localized_specialty":{
        "id":154,
        "specialty_id":8,
        "state_id":44,
        "name":"Licensed Vocational Nurse",
        "abbreviation":"LVN",
        "specialty":{
            "id":8,
            "name":"Licensed Vocational\/Practical Nurse",
            "color":"#AF52DE",
            "abbreviation":"LVN\/LPN"
        }
    }
}
 */
@Keep
internal data class ShiftItemDTO(
    @SerializedName("shift_id")
    val shiftId: Long,
    @SerializedName("normalized_start_date_time")
    val startTime: String,
    @SerializedName("normalized_end_date_time")
    val endTime: String,
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
