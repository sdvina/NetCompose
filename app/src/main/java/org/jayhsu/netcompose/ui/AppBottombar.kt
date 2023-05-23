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
    appNavigation: AppNavigation
 ) {
    val appBottomNavState = remember { mutableStateOf(AppBottomNavType.HOME) }
    BottomAppBar(
        actions = {
            NavigationBar(
                modifier = modifier
            ) {
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.HOME,
                    onClick = {
                        appNavigation.navigateToHome
                        appBottomNavState.value = AppBottomNavType.HOME
                    },
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) },
                    label = { Text(text = stringResource(R.string.home)) }
                )
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.DOC,
                    onClick = {
                        appNavigation.navigateToDoc
                        appBottomNavState.value = AppBottomNavType.DOC
                    },
                    icon = { Icon(imageVector = Icons.Filled.LibraryBooks, contentDescription = null) },
                    label = { Text(text = stringResource(R.string.docs)) }
                )
                NavigationBarItem(
                    selected = appBottomNavState.value == AppBottomNavType.TEMPLATE,
                    onClick = {
                        appNavigation.navigateToTemplate
                        appBottomNavState.value = AppBottomNavType.TEMPLATE
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
            appNavigation = appNavigation
        )
    }
}