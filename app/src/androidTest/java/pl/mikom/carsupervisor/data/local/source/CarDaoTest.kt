package pl.mikom.carsupervisor.data.local.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.mikom.carsupervisor.data.local.model.CarEntityTestUtil

class CarDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: CarSupervisorDatabase
    private lateinit var tested: CarDao

    @Before
    fun setUp() {
        setUpDatabase()
        tested = database.carDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertCar_addsRecord() = runTest {
        tested.insertCar(CarEntityTestUtil.defaultCar)

        val result = tested.getAllCars()
        result.size shouldBe 1
    }

    @Test
    fun getAllCars_returnsAllRecords() = runTest {
        val cars = List(2) {
            CarEntityTestUtil.generateCar(id = it.toLong())
        }
        cars.forEach {
            tested.insertCar(it)
        }

        val result = tested.getAllCars()

        result.size shouldBe 2
    }

    private fun setUpDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CarSupervisorDatabase::class.java
        ).allowMainThreadQueries().build()
    }
}