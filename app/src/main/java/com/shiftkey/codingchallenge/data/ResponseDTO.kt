package com.shiftkey.codingchallenge.data

import androidx.annotation.Keep

@Keep
internal data class ResponseDTO(
    val data: List<DateDTO>,
    val links: List<LinkDTO>,
    val meta: MetaDTO,
)
