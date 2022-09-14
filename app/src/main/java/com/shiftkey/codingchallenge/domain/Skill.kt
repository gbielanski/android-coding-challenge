package com.shiftkey.codingchallenge.domain

import android.os.Parcelable
import com.shiftkey.codingchallenge.data.SkillDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Skill(
    val name: String,
    val color: String,
) : Parcelable

internal fun skillOf(dto: SkillDTO) = Skill(
    dto.name,
    dto.color
)
