package com.yusuf.launches.di

import com.yusuf.launches.repository.LaunchesRepository
import com.yusuf.launches.repository.LaunchesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonRepositoryModule {

    @Binds
    abstract fun provideGeneralRepository(
        generalRepositoryImpl: LaunchesRepositoryImpl
    ): LaunchesRepository

}
