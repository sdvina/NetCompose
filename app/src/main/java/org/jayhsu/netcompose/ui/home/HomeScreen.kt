package org.jayhsu.netcompose.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NetworkPing
import androidx.compose.material3.*
import androidx.compose.material3.ListItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import org.jayhsu.netcompose.ui.AppBottomNavType
import org.jayhsu.netcompose.ui.AppNavigation
import org.jayhsu.netcompose.ui.AppBottomBar
import org.jayhsu.netcompose.R
import org.jayhsu.netcompose.data.model.HomeScreenItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appNavigation: AppNavigation,
    viewModel: HomeViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name))},
                modifier = modifier,
                navigationIcon = { Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)},
                actions = {
                }
            )
        },
        bottomBar = {
            AppBottomBar(
                appNavigation = appNavigation
            )
        }
    ) { innerPadding ->
        HomeScreenContent(
            modifier = Modifier.padding(innerPadding),
            appNavigation = appNavigation
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    appNavigation: AppNavigation
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        item {
            Divider()
            ContentItem(
                name = stringResource(HomeScreenItems.RequestMethod.name),
                imageVector = Icons.Outlined.NetworkPing,
                clickable = appNavigation.navigateToRequestMethod
            )
        }
        /*item {
            ContentItem(
                name = stringResource(HomeScreenItems.SyncRequest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.ViewModelRequest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.AsyncTask.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.AutoDialog.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.CoroutineScope.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.NavConverter.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.ErrorHandle.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.ExceptionTrace.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.Interceptor.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.HttpsCertificate.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.ParallelNetwork.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.PushRefresh.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.PullRefresh.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.StateLayout.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.ReadCache.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.PreviewCache.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.Fastest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.UniqueRequest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.EditDebounce.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.SwitchDispatcher.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.DownloadFile.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.UploadFile.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.SuperInterval.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.CallbackRequest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.LimitedTime.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }
        item {
            ContentItem(
                name = stringResource(HomeScreenItems.TimingRequest.name),
                imageVector = Icons.Outlined.NetworkPing
            )
        }*/
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(
    name: String,
    imageVector: ImageVector,
    clickable: () -> Unit
){
    ListItem(
        modifier = Modifier.clickable { clickable() },
        headlineText = { Text(name) },
        leadingContent = {
            Icon(
                imageVector = imageVector,
                contentDescription = name,
            )
        }

    )
    Divider()
}
