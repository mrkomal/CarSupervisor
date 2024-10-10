package pl.mikom.carsupervisor.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.mikom.carsupervisor.domain.repository.CarRepository
import pl.mikom.carsupervisor.domain.usecase.AddCarUseCase
import pl.mikom.carsupervisor.domain.usecase.GetAllCarsUseCase

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Provides
    fun provideAddCarUseCase(repository: CarRepository) = AddCarUseCase(repository)

    @Provides
    fun provideGetAllCarsUseCase(repository: CarRepository) = GetAllCarsUseCase(repository)
}
