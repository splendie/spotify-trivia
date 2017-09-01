package com.indri.musictrivia.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.indri.musictrivia.app.MusicTriviaApplication


/**
 * Created by Indri on 29/08/2017.
 */
object PrefUtil {

    val context: Context = MusicTriviaApplication.instance.applicationContext
    val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var editor: SharedPreferences.Editor = pref.edit()

    enum class Key {
        KEY_SPOTIFY_TOKEN,
        KEY_SPOTIFY_CODE,
    }

    fun put(key: Key, value: String) {
        doEdit()
        editor.putString(key.name, value)
        doCommit()
    }

    fun put(key: Key, value: Int) {
        doEdit()
        editor.putInt(key.name, value)
        doCommit()
    }

    fun put(key: Key, value: Boolean) {
        doEdit()
        editor.putBoolean(key.name, value)
        doCommit()
    }

    fun put(key: Key, value: Float) {
        doEdit()
        editor.putFloat(key.name, value)
        doCommit()
    }

    fun getString(key: String, defaultValue: String): String {
        return pref.getString(key, defaultValue)
    }

    fun getString(key: String): String {
        return pref.getString(key, "")
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return pref.getInt(key, defaultValue)
    }

    fun getLong(key: String): Long {
        return pref.getLong(key, 0)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return pref.getLong(key, defaultValue)
    }

    fun getFloat(key: String): Float {
        return pref.getFloat(key, 0F)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return pref.getFloat(key, defaultValue)
    }

    /**
     * Convenience method for retrieving doubles.

     * There may be instances where the accuracy of a double is desired.
     * SharedPreferences does not handle doubles so they have to
     * cast to and from String.

     * @param key The name of the preference to fetch.
     */
    fun getDouble(key: String): Double {
        return getDouble(key, 0.0)
    }

    /**
     * Convenience method for retrieving doubles.

     * There may be instances where the accuracy of a double is desired.
     * SharedPreferences does not handle doubles so they have to
     * cast to and from String.

     * @param key The name of the preference to fetch.
     */
    fun getDouble(key: String, defaultValue: Double): Double {
        try {
            return java.lang.Double.valueOf(pref.getString(key, defaultValue.toString()))
        } catch (nfe: NumberFormatException) {
            return defaultValue
        }

    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    /**
     * Remove keys from SharedPreferences.

     * @param keys The name of the key(s) to be removed.
     */
    fun remove(vararg keys: String) {
        doEdit()
        for (key in keys) {
            editor.remove(key)
        }
        doCommit()
    }

    /**
     * Remove all keys from SharedPreferences.
     */
    fun clear() {
        doEdit()
        editor.clear()
        doCommit()
    }

    private fun doEdit() {
        if (editor == null) {
            editor = pref.edit()
        }
    }

    private fun doCommit() {
        if (editor != null) {
            editor.commit()
        }
    }

}