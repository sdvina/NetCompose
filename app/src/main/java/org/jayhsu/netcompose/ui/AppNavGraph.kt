package org.jayhsu.netcompose.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.jayhsu.netcompose.repository.AppContainer
import org.jayhsu.netcompose.ui.doc.DocScreen
import org.jayhsu.netcompose.ui.home.HomeScreen
import org.jayhsu.netcompose.ui.home.HomeViewModel

object AppDestinations {
    const val HOME = "home"
    const val DOC = "doc"
    const val TEMPLATE = "template"
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph (
    navController: NavHostController,
    appNavigation: AppNavigation,
    appContainer: AppContainer
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = AppDestinations.HOME,
        modifier = Modifier,
        enterTransition = {
            fadeIn(animationSpec = tween(750))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(750))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(750))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(750))
        }
    ){
        composable(AppDestinations.HOME) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory(appContainer)
            )
            HomeScreen(
                appNavigation = appNavigation,
                viewModel = homeViewModel
            )
        }
        composable(AppDestinations.DOC){
            DocScreen()
        }
        composable(AppDestinations.TEMPLATE){
        }
    }
}