package org.jayhsu.netcompose.ui.home.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.drake.net.Delete
import com.drake.net.Get
import com.drake.net.Head
import com.drake.net.Options
import com.drake.net.Patch
import com.drake.net.Post
import com.drake.net.Put
import com.drake.net.Trace
import com.drake.net.utils.scopeNetLife
import org.jayhsu.netcompose.R
import org.jayhsu.netcompose.ui.AppBottomBar
import org.jayhsu.netcompose.ui.AppBottomNavType
import org.jayhsu.netcompose.ui.AppNavigation
import org.jayhsu.netcompose.ui.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestMethodScreen(
    modifier: Modifier = Modifier,
    appBottomNavState: MutableState<AppBottomNavType>,
    appNavigation: AppNavigation,
    viewModel: HomeViewModel
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                modifier = modifier,
                navigationIcon = { Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null) },
                actions = {
                }
            )
        },
        bottomBar = {
            AppBottomBar(
                appBottomNavState = appBottomNavState,
                appNavigation = appNavigation
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ){

            Text(text = "111111111111111111")

        }
    }
}