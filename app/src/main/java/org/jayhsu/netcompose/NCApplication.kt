package org.jayhsu.netcompose

import android.app.Application
import org.jayhsu.netcompose.data.local.AppPreferences
import org.jayhsu.netcompose.repository.AppContainer
import org.jayhsu.netcompose.repository.AppContainerImpl

class NCApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
        container = AppContainerImpl()
    }
}