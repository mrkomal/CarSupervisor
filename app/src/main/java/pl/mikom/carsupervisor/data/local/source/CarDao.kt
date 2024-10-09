package pl.mikom.carsupervisor.data.local.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.ABORT
import androidx.room.Query
import pl.mikom.carsupervisor.data.local.model.CarEntity

@Dao
interface CarDao {

    @Insert(onConflict = ABORT)
    suspend fun insertCar(car: CarEntity)

    @Query("SELECT * FROM ${CarEntity.TABLE_NAME}")
    suspend fun getAllCars(): List<CarEntity>
}
