package pl.mikom.carsupervisor.domain.usecase

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import pl.mikom.carsupervisor.domain.model.Car
import pl.mikom.carsupervisor.domain.repository.CarRepository

class AddCarUseCaseTest {

    private val repository: CarRepository = mockk()
    private val tested = AddCarUseCase(repository)

    @Test
    fun addCar_callsRepository() = runTest {
        val car = mockk<Car>()
        coEvery { repository.insert(car) } returns Unit

        tested(car)

        coVerify { repository.insert(car) }
    }
}
