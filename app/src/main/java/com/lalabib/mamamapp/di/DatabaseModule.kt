package com.lalabib.mamamapp.di

import android.content.Context
import androidx.room.Room
import com.lalabib.mamamapp.data.local.room.MealFavoriteDao
import com.lalabib.mamamapp.data.local.room.MealsFavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MealsFavoriteDatabase {

        return Room.databaseBuilder(context, MealsFavoriteDatabase::class.java, "MealsFavorite.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMealsDao(database: MealsFavoriteDatabase): MealFavoriteDao = database.mealsDao()
}