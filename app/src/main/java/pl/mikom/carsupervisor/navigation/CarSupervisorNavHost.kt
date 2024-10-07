package pl.mikom.carsupervisor.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pl.mikom.carsupervisor.screens.CarsListRoute
import pl.mikom.carsupervisor.screens.addNewCarScreen
import pl.mikom.carsupervisor.screens.carDetailsScreen
import pl.mikom.carsupervisor.screens.carsListScreen
import pl.mikom.carsupervisor.screens.navigateToAddNewCar
import pl.mikom.carsupervisor.screens.navigateToCarDetails

@Composable
fun CarSupervisorNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CarsListRoute
    ) {
        carsListScreen(
            onAddClick = navController::navigateToAddNewCar,
            onCarClicked = navController::navigateToCarDetails
        )
        addNewCarScreen(
            onBackClicked = navController::popBackStack
        )
        carDetailsScreen(
            onBackClicked = navController::popBackStack
        )
    }
}
