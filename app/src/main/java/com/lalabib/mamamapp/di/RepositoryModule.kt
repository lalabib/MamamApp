package com.lalabib.mamamapp.di

import com.lalabib.mamamapp.data.remote.MealsRepository
import com.lalabib.mamamapp.domain.repository.IMealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(mealsRepository: MealsRepository) : IMealsRepository
}