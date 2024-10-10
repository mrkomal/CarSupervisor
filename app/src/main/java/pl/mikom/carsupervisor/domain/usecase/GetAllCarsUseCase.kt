package pl.mikom.carsupervisor.domain.usecase

import pl.mikom.carsupervisor.domain.repository.CarRepository
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(
    private val repository: CarRepository
){

    suspend operator fun invoke() = repository.getAll()
}
