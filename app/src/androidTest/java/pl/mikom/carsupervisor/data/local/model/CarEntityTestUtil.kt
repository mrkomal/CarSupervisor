package pl.mikom.carsupervisor.data.local.model

object CarEntityTestUtil {

    val defaultCar: CarEntity
        get() = generateCar(1L, "ELTEST")

    fun generateCar(
        id: Long = 1L,
        registration: String = "ELTEST${id}"
    ) = CarEntity(
        id = id,
        registration = registration
    )
}
