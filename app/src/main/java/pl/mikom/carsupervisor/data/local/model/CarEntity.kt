package pl.mikom.carsupervisor.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarEntity(
    @PrimaryKey val id: Long,
    val registration: String
)
