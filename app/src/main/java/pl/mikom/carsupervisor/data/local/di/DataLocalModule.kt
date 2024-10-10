package pl.mikom.carsupervisor.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.mikom.carsupervisor.data.local.repository.CarRepositoryImpl
import pl.mikom.carsupervisor.data.local.source.CarSupervisorDatabase
import pl.mikom.carsupervisor.domain.repository.CarRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataLocalModule {

    @Binds
    fun bindCarRepository(
        carRepositoryImpl: CarRepositoryImpl
    ): CarRepository

    companion object {

        @Singleton
        @Provides
        fun provideRoomDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
            appContext,
            CarSupervisorDatabase::class.java,
            CarSupervisorDatabase.DB_NAME
        ).build()

        @Singleton
        @Provides
        fun provideCarApi(database: CarSupervisorDatabase) = database.carDao()
    }
}
