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
object CarsListRoute

fun NavController.navigateToCarsList(navOptions: NavOptions) =
    navigate(route = CarsListRoute, navOptions)

fun NavGraphBuilder.carsListScreen(
    onAddClick: () -> Unit,
    onCarClicked: (Int) -> Unit
) {
    composable<CarsListRoute> {
        CarsListScreen(
            onAddClick = onAddClick,
            onCarClicked = onCarClicked
        )
    }
}

@Composable
fun CarsListScreen(
    onAddClick: () -> Unit,
    onCarClicked: (Int) -> Unit
) {
    Column {
        Text(text = "Cars list")
        Button(onClick = onAddClick) {
            Text(text = "Add")
        }
        Button(onClick = { onCarClicked(1) }) {
            Text(text = "Car")
        }
    }
}
