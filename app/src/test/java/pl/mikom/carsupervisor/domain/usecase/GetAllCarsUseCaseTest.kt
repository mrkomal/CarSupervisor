package pl.mikom.carsupervisor.domain.usecase

import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import pl.mikom.carsupervisor.domain.model.Car
import pl.mikom.carsupervisor.domain.repository.CarRepository

class GetAllCarsUseCaseTest {

    private val repository: CarRepository = mockk()
    private val tested = GetAllCarsUseCase(repository)

    @Test
    fun getAllCars_returnsCarsList() = runTest {
        val cars = List(5) { mockk<Car>() }
        coEvery { repository.getAll() } returns cars

        val result = tested()

        result shouldBe cars
    }
}
