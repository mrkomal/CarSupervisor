package pl.mikom.carsupervisor.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CarEntity.TABLE_NAME)
data class CarEntity(
    @PrimaryKey val id: Long,
    val registration: String
) {

    companion object {

        const val TABLE_NAME = "car"
    }
}
