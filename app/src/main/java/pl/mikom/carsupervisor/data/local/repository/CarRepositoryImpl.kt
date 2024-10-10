package pl.mikom.carsupervisor.data.local.repository

import pl.mikom.carsupervisor.data.local.model.CarEntity
import pl.mikom.carsupervisor.data.local.source.CarDao
import pl.mikom.carsupervisor.domain.model.Car
import pl.mikom.carsupervisor.domain.model.Registration
import pl.mikom.carsupervisor.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val dao: CarDao
): CarRepository {

    override suspend fun insert(car: Car) = dao.insertCar(car.toData())

    override suspend fun getAll() = dao.getAllCars().map {
        it.toDomain()
    }
}

private fun CarEntity.toDomain() = Car(
    id = id,
    registration = Registration(registration)
)

private fun Car.toData() = CarEntity(
    id = id,
    registration = registration.value
)
