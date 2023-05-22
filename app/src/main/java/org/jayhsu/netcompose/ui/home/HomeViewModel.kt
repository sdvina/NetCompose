package org.jayhsu.netcompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.jayhsu.netcompose.repository.AppContainer

class HomeViewModel(
    appContainer: AppContainer
): ViewModel() {

    companion object {
        fun provideFactory(
            appContainer: AppContainer
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(appContainer) as T
            }
        }
    }
}