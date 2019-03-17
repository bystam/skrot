package com.decubate.skrot

import android.content.Context
import android.preference.PreferenceManager

class PreferenceHandler {
    fun getUserId(context: Context): String? =
        PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_USER_ID, null)

    fun setUserId(context: Context, userId: String) {
        PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putString(KEY_USER_ID, userId)
            .apply()
    }

    companion object {
        const val KEY_USER_ID = "KEY_USER_ID"
    }
}