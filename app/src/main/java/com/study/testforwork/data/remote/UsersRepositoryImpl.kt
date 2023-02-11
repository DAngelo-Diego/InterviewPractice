package com.study.testforwork.data.remote

import com.study.testforwork.data.mappers.toDomain
import com.study.testforwork.domain.model.UsersModel
import com.study.testforwork.domain.repository.UsersRepository
import com.study.testforwork.domain.util.Resource
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor (
    private val usersApi: UsersApi
        ): UsersRepository {
    override suspend fun fetchUsersRepository(): Resource<UsersModel> {
        return try {
            Resource.Success(
                data = usersApi.fetchUsersFromApi().results.first().toDomain()
            )
        } catch (e: Exception) {
            Resource.Error(message = "Unknown error $e")
        }
    }
}