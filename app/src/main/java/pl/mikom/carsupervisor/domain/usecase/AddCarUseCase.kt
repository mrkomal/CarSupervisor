package pl.mikom.carsupervisor.domain.usecase

import pl.mikom.carsupervisor.domain.model.Car
import pl.mikom.carsupervisor.domain.repository.CarRepository
import javax.inject.Inject

class AddCarUseCase @Inject constructor(
    private val repository: CarRepository
) {

    suspend operator fun invoke(car: Car) = repository.insert(car)
}
