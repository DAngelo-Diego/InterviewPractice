package com.study.testforwork.data.remote

import com.study.testforwork.domain.model.UsersModel
import com.study.testforwork.domain.repository.UsersRepository

class UsersRepositoryImpl: UsersRepository {
    override suspend fun fetchUsersRepository(): UsersModel {
        TODO("Not yet implemented")
    }
}