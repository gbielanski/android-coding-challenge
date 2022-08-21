package com.shiftkey.codingchallenge.data

import retrofit2.http.GET
import retrofit2.http.Query

internal interface ShiftsApi {
    @GET("available_shifts/")
    suspend fun shifts(
        @Query("address") address: String,
        @Query("start") start: String,
        @Query("end") end: String,
        @Query("type") type: String,
    ): ResponseDTO
}
