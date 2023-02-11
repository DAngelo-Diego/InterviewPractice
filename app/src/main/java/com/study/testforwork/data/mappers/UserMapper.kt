package com.study.testforwork.data.mappers

import com.study.testforwork.data.remote.response.ResultDto
import com.study.testforwork.domain.model.UsersModel

fun ResultDto.toDomain(): UsersModel {
    return UsersModel(
        name = "${this.name.first}${this.name.last}",
        email = this.email,
        birthday = this.dob.date,
        age = this.dob.age,
        address = this.location.city,
        phoneNumber = this.phone,
        password = this.login.password
    )
}