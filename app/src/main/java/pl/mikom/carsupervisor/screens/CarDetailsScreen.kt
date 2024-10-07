package pl.mikom.carsupervisor.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
class CarDetailsRoute(val carId: Int)

fun NavController.navigateToCarDetails(carId: Int, navOptions: NavOptions? = null) =
    navigate(route = CarDetailsRoute(carId = carId), navOptions)

fun NavGraphBuilder.carDetailsScreen(onBackClicked: () -> Unit) {
    composable<CarDetailsRoute> {
        CarDetailsScreen(onBackClicked = onBackClicked)
    }
}

@Composable
fun CarDetailsScreen(onBackClicked: () -> Unit) {
    Column {
        Text(text = "Car details")
        Button(onClick = onBackClicked) {
            Text(text = "Back")
        }
    }
}
