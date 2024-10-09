package pl.mikom.carsupervisor.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.mikom.carsupervisor.data.local.source.CarSupervisorDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {

    companion object {

        @Singleton
        @Provides
        fun provideRoomDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
            appContext,
            CarSupervisorDatabase::class.java,
            CarSupervisorDatabase.DB_NAME
        ).build()
    }
}
