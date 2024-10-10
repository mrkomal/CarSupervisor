package pl.mikom.carsupervisor.domain.repository

import pl.mikom.carsupervisor.domain.model.Car

interface CarRepository {

    suspend fun insert(car: Car)

    suspend fun getAll(): List<Car>
}
