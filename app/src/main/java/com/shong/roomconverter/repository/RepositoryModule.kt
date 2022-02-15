package com.shong.roomconverter.repository

import android.content.Context
import androidx.room.Room
import com.shong.roomconverter.db.AppDatabase
import com.shong.roomconverter.db.example.ExampleDao
import com.shong.roomconverter.db.example2.ExampleDao2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideExampleDao(database: AppDatabase): ExampleDao {
        return database.exampleDao()
    }


    @Singleton
    @Provides
    fun provideRepository(
        exampleDao: ExampleDao,
    ): ExampleRepository {
        return ExampleRepository(exampleDao)
    }

    @Singleton
    @Provides
    fun provideExampleDao2(database: AppDatabase): ExampleDao2 {
        return database.exampleDao2()
    }

    @Singleton
    @Provides
    fun provideRepository2(
        exampleDao2: ExampleDao2,
    ): ExampleRepository2 {
        return ExampleRepository2(exampleDao2)
    }

}