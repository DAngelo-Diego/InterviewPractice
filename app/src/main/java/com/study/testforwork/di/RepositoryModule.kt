package com.study.testforwork.di

import com.study.testforwork.data.remote.UsersRepositoryImpl
import com.study.testforwork.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUsersRepository(usersRepositoryImpl: UsersRepositoryImpl) : UsersRepository


}