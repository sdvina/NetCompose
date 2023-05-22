package org.jayhsu.netcompose.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.jayhsu.netcompose.ui.theme.AppTheme
import org.jayhsu.netcompose.R

enum class AppBottomNavType {
    HOME,
    DOC,
    TEMPLATE
}

@Composable
 fun AppBottomBar(
    modifier: Modifier = Modifier,
    appBottomNavState: MutableState<AppBottomNavType>,
    appNavigation: AppNavigation
 ) {
    BottomAppBar(
        actions = {
            NavigationBar(
                modifier = modifier
            ) {
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.HOME,
                    onClick = {
                        appBottomNavState.value = AppBottomNavType.HOME
                        appNavigation.navigateToHome
                    },
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) },
                    label = { Text(text = stringResource(R.string.home)) }
                )
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.DOC,
                    onClick = {
                        appBottomNavState.value = AppBottomNavType.DOC
                        appNavigation.navigateToDoc
                    },
                    icon = { Icon(imageVector = Icons.Filled.LibraryBooks, contentDescription = null) },
                    label = { Text(text = stringResource(R.string.docs)) }
                )
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.TEMPLATE,
                    onClick = {
                        appBottomNavState.value = AppBottomNavType.TEMPLATE
                        appNavigation.navigateToTemplate
                    },
                    icon = { Icon(imageVector = Icons.Filled.Apps, contentDescription = null) },
                    label = { Text(text = stringResource(R.string.template)) }
                )
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun AppBottomBarPreview(){
    AppTheme() {
        val navController = rememberAnimatedNavController()
        val appNavigation = remember(navController) { AppNavigation(navController) }
        AppBottomBar(
            appBottomNavState = remember { mutableStateOf(AppBottomNavType.HOME) },
            appNavigation = appNavigation
        )
    }
}