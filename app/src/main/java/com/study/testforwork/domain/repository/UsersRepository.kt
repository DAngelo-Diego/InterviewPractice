package com.study.testforwork.domain.repository

import com.study.testforwork.domain.model.UsersModel

interface UsersRepository {

    suspend fun fetchUsersRepository(): UsersModel

}