package org.jayhsu.netcompose.ui.doc

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LogoDev
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.web.*
import org.jayhsu.netcompose.data.constant.AppConstant
import org.jayhsu.netcompose.data.local.AppPreferences
import org.jayhsu.netcompose.ui.theme.AppTheme
import org.jayhsu.netcompose.R
import org.jayhsu.netcompose.ui.AppBottomBar
import org.jayhsu.netcompose.ui.AppBottomNavType
import org.jayhsu.netcompose.ui.AppNavigation

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocScreen(
    modifier: Modifier = Modifier,
    appNavigation: AppNavigation
) {
    val urlState = remember { mutableStateOf(AppPreferences.lastViewedUrl!!) }
    val webViewState = rememberWebViewState(url = urlState.value)
    val snackbarHostState = remember { SnackbarHostState() }
    val searchState = remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier,
        topBar = {
            ReferenceTopBar(
                urlState = urlState,
                searchState = searchState
            )
        },
        bottomBar = {
            AppBottomBar(
                appNavigation = appNavigation
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        val webClient = remember {
            object : AccompanistWebViewClient() {

                override fun onPageStarted(
                    view: WebView?,
                    url: String?,
                    favicon: Bitmap?
                ) {
                    super.onPageStarted(view, url, favicon)
                    urlState.value =  url!!
                    AppPreferences.lastViewedUrl = url
                }
            }
        }
        WebView(
            state = webViewState,
            modifier = modifier.padding(innerPadding),
            navigator = rememberWebViewNavigator(),
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
                webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
            },
            client = webClient
        )

        if(searchState.value) webClient.navigator.reload()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferenceTopBar(
    modifier: Modifier = Modifier,
    urlState: MutableState<String>,
    searchState: MutableState<Boolean>
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.clickable {
                    urlState.value = AppConstant.DOC_URL
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.LogoDev,
                contentDescription = null
            )
        },
        actions = {
            IconButton(
                onClick = {
                    searchState.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
        }
    )
}