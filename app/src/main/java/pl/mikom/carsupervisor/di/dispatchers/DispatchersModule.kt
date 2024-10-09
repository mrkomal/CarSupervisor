package pl.mikom.carsupervisor.di.dispatchers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import pl.mikom.carsupervisor.di.dispatchers.CarSupervisorDispatchers.Default
import pl.mikom.carsupervisor.di.dispatchers.CarSupervisorDispatchers.IO
import pl.mikom.carsupervisor.di.dispatchers.CarSupervisorDispatchers.Main

@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {

    @Provides
    @Dispatcher(Main)
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
