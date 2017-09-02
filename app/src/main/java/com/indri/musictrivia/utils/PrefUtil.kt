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
        KEY_SPOTIFY_ACCESS_TOKEN,
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

    fun getString(key: Key, defaultValue: String): String {
        return pref.getString(key.name, defaultValue)
    }

    fun getString(key: Key): String {
        return pref.getString(key.name, "")
    }

    fun getInt(key: Key): Int {
        return pref.getInt(key.name, 0)
    }

    fun getInt(key: Key, defaultValue: Int): Int {
        return pref.getInt(key.name, defaultValue)
    }

    fun getLong(key: Key): Long {
        return pref.getLong(key.name, 0)
    }

    fun getLong(key: Key, defaultValue: Long): Long {
        return pref.getLong(key.name, defaultValue)
    }

    fun getFloat(key: Key): Float {
        return pref.getFloat(key.name, 0F)
    }

    fun getFloat(key: Key, defaultValue: Float): Float {
        return pref.getFloat(key.name, defaultValue)
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