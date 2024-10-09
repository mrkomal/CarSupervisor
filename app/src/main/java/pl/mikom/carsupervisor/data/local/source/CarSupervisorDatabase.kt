package pl.mikom.carsupervisor.data.local.source

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.mikom.carsupervisor.data.local.model.CarEntity
import pl.mikom.carsupervisor.data.local.source.CarSupervisorDatabase.Companion.DB_VERSION

@Database(
    entities = [
        CarEntity::class
    ],
    version = DB_VERSION,
    exportSchema = true
)
abstract class CarSupervisorDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {

        const val DB_VERSION = 1
        const val DB_NAME = "car_supervisor_database"
    }
}
