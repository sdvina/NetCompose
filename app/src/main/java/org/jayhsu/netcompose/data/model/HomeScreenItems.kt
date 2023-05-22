package org.jayhsu.netcompose.data.model

import androidx.annotation.StringRes
import org.jayhsu.netcompose.R

sealed class HomeScreenItems {
    object AsyncTask : HomeScreenItems()
    object AutoDialog : HomeScreenItems()
    object CallbackRequest : HomeScreenItems()
    object CoroutineScope : HomeScreenItems()
    object DownloadFile : HomeScreenItems()
    object EditDebounce : HomeScreenItems()
    object ErrorHandle : HomeScreenItems()
    object ExceptionTrace : HomeScreenItems()
    object Fastest : HomeScreenItems()
    object HttpsCertificate : HomeScreenItems()
    object Interceptor : HomeScreenItems()
    object LimitedTime : HomeScreenItems()
    object NavConverter : HomeScreenItems()
    object ParallelNetwork : HomeScreenItems()
    object PreviewCache : HomeScreenItems()
    object PullRefresh : HomeScreenItems()
    object PushRefresh : HomeScreenItems()
    object ReadCache : HomeScreenItems()
    object RequestMethod : HomeScreenItems()
    object StateLayout : HomeScreenItems()
    object SuperInterval : HomeScreenItems()
    object SwitchDispatcher : HomeScreenItems()
    object SyncRequest : HomeScreenItems()
    object TimingRequest : HomeScreenItems()
    object UniqueRequest : HomeScreenItems()
    object UploadFile : HomeScreenItems()
    object ViewModelRequest : HomeScreenItems()

    @get:StringRes
    val name: Int
        get() = when (this) {
            AsyncTask -> R.string.async_task
            AutoDialog -> R.string.auto_Dialog
            CallbackRequest -> R.string.callback_request
            CoroutineScope -> R.string.coroutine_scope
            DownloadFile -> R.string.download_file
            EditDebounce -> R.string.edit_debounce
            ErrorHandle -> R.string.error_handle
            ExceptionTrace -> R.string.exception_trace
            Fastest -> R.string.fastest
            HttpsCertificate -> R.string.http_certificate
            Interceptor -> R.string.interceptor
            LimitedTime -> R.string.limited_time
            NavConverter -> R.string.nav_converter
            ParallelNetwork -> R.string.parallel_network
            PreviewCache -> R.string.preview_cache
            PullRefresh -> R.string.pull_refresh
            PushRefresh -> R.string.push_refresh
            ReadCache -> R.string.read_cache
            RequestMethod -> R.string.request_method
            StateLayout -> R.string.state_layout
            SuperInterval -> R.string.super_interval
            SwitchDispatcher -> R.string.switch_dispatcher
            SyncRequest -> R.string.sync_request
            TimingRequest -> R.string.timing_request
            UniqueRequest -> R.string.unique_request
            UploadFile -> R.string.upload_file
            ViewModelRequest -> R.string.view_model_request
        }
}