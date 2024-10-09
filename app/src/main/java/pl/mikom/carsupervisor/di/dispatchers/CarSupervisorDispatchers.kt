package pl.mikom.carsupervisor.di.dispatchers

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val carSupervisorDispatchers: CarSupervisorDispatchers)

enum class CarSupervisorDispatchers {
    Main,
    IO,
    Default
}
