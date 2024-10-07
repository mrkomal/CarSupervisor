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
object AddNewCarRoute

fun NavController.navigateToAddNewCar(navOptions: NavOptions? = null) =
    navigate(route = AddNewCarRoute, navOptions)

fun NavGraphBuilder.addNewCarScreen(onBackClicked: () -> Unit) {
    composable<AddNewCarRoute> {
        AddNewCarScreen(onBackClicked = onBackClicked)
    }
}

@Composable
fun AddNewCarScreen(onBackClicked: () -> Unit) {
    Column {
        Text(text = "Add car")
        Button(onClick = onBackClicked) {
            Text(text = "Back")
        }
    }
}
