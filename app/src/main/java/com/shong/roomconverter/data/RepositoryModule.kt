package com.shong.roomconverter.data

import android.content.Context
import androidx.room.Room
import com.shong.roomconverter.data.db.AppDatabase
import com.shong.roomconverter.data.db.dao.ExampleDao
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
        @ApplicationContext context: Context,
        exampleDao: ExampleDao,
    ): Repository {
        return Repository(context, exampleDao)
    }

}