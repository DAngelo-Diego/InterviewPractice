package com.study.testforwork.data.remote.response

data class LocationDto(
    val city: String,
    val coordinates: CoordinatesDto,
    val country: String,
    val postcode: String,
    val state: String,
    val street: StreetDto,
    val timezone: TimezoneDto
)