package org.jayhsu.netcompose.data.local

import android.content.Context
import android.content.SharedPreferences
import org.jayhsu.netcompose.data.constant.AppConstant

object AppPreferences {
    private lateinit var prefs: SharedPreferences
    private const val NAME = "AppPreferences"

    private const val LAST_VIEWED_URL = "last_viewed_url"

    fun init(context: Context) {
        prefs = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(
        performEdit: (SharedPreferences.Editor) -> Unit
    ) {
        val editor = this.edit()
        performEdit(editor)
        editor.apply()
    }

    var lastViewedUrl: String?
        get() = prefs.getString(LAST_VIEWED_URL, AppConstant.DOC_URL)
        set(value) = prefs.edit { it.putString(LAST_VIEWED_URL, value) }
}