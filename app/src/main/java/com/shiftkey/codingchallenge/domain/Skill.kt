package com.shiftkey.codingchallenge.domain

import androidx.compose.ui.graphics.Color
import com.shiftkey.codingchallenge.data.SkillDTO

internal data class Skill(
    val name: String,
    val color: Color,
) {
    constructor(dto: SkillDTO) : this(
        dto.name,
        dto.color.toComposeColor()
    )
}
