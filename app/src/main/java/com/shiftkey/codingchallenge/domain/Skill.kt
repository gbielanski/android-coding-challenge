package com.shiftkey.codingchallenge.domain

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import com.shiftkey.codingchallenge.data.SkillDTO
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Skill(
    val name: String,
    val color: String,
) : Parcelable {
    constructor(dto: SkillDTO) : this(
        dto.name,
        dto.color
    )
}
