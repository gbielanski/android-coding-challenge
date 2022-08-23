package com.shiftkey.codingchallenge

import com.shiftkey.codingchallenge.domain.*

internal const val START_TIME = "2022-08-20 19:00:00"
internal const val END_TIME = "2022-08-21 19:00:00"
internal const val KIND = "Day Shift"
internal const val FACILITY = "Skilled Nursing Facility"
internal const val SKILL = "Long Term Care"

internal val testScreenState = ShiftItem(
    shiftId = 1L,
    startTime = "2022-08-20T19:00:00",
    endTime = "2022-08-21T19:00:00",
    normalizedStartTime = START_TIME,
    normalizedEndTime = END_TIME,
    isPremiumRate = true,
    isCovid = true,
    kind = KIND,
    skill = Skill(
        name = SKILL,
        color = "#007AFF",
    ),
    facilityType = FacilityType(
        name = FACILITY,
        color = "#AF52DE"
    ),
    localizedSpecialty = LocalizedSpecialty(
        name = "Certified Nursing Aide",
        abbreviation = "CNA",
        specialty = Specialty(
            name = "Certified Nursing Aide",
            color = "#007AFF",
            abbreviation = "CNA",
        )
    )
)
