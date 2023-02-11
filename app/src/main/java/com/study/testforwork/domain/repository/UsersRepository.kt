package com.study.testforwork.domain.repository

import com.study.testforwork.domain.model.UsersModel
import com.study.testforwork.domain.util.Resource

interface UsersRepository {
    suspend fun fetchUsersRepository(): Resource<UsersModel>
}