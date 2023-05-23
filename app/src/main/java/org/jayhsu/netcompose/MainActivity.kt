package org.jayhsu.netcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.jayhsu.netcompose.repository.AppContainer
import org.jayhsu.netcompose.repository.AppContainerImpl
import org.jayhsu.netcompose.ui.AppBottomNavType
import org.jayhsu.netcompose.ui.AppNavGraph
import org.jayhsu.netcompose.ui.AppNavigation
import org.jayhsu.netcompose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (application as NCApplication).container
        setContent { NCApp(appContainer) }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NCApp(
    appContainer: AppContainer
) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberAnimatedNavController()
            val appNavigation = remember(navController) { AppNavigation(navController) }
            AppNavGraph(
                navController = navController,
                appNavigation = appNavigation,
                appContainer = appContainer
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NCAppPreview() {
    NCApp(AppContainerImpl())
}