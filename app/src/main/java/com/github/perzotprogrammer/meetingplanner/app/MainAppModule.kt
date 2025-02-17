package com.github.perzotprogrammer.meetingplanner.app

import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseAuthRepository
import com.github.perzotprogrammer.meetingplanner.core.repository.FirebaseDataStorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainAppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthRepository(): FirebaseAuthRepository {
        return FirebaseAuthRepository()
    }

    @Provides
    @Singleton
    fun provideFirebaseDataStorageRepository(): FirebaseDataStorageRepository {
        return FirebaseDataStorageRepository()
    }
}