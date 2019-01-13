package com.triarc.tutorial.android.mvp.storage

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 13/1/19
 */
class PreferenceManager @Inject constructor(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(Name, Context.MODE_PRIVATE)
    private val preferenceEditor:  SharedPreferences.Editor by lazy {
        sharedPreferences.edit()
    }

    companion object {
        const val Name = "mvp_shared_prefs"
    }

    fun getStringSet(key: String): HashSet<String>? {
        return sharedPreferences.getStringSet(key, HashSet<String>()) as? HashSet
    }

    @Synchronized
    fun setStringSet(key: String, value: HashSet<String>?) {
        preferenceEditor.clear()
        preferenceEditor.putStringSet(key, value)
        preferenceEditor.apply()
    }
}
