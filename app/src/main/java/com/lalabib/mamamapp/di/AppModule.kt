package com.lalabib.mamamapp.di

import com.lalabib.mamamapp.data.remote.MealsRepository
import com.lalabib.mamamapp.domain.usecase.MealsInteractor
import com.lalabib.mamamapp.domain.usecase.MealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealsUseCase(mealsRepository: MealsRepository): MealsUseCase =
        MealsInteractor(mealsRepository)
}