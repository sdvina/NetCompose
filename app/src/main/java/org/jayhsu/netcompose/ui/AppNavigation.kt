package org.jayhsu.netcompose.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class AppNavigation (
    navController: NavHostController
) {
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestinations.HOME) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToRequestMethod: () -> Unit = {
        navController.navigate(AppDestinations.REQUEST_METHOD) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
        }
    }
    val navigateToDoc: () -> Unit = {
        navController.navigate(AppDestinations.DOC) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToTemplate: () -> Unit = {
        navController.navigate(AppDestinations.TEMPLATE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigationToBack: () -> Unit = {
        navController.navigateUp()
    }
}