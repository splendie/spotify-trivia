package com.indri.musictrivia.app

import android.app.Application
import android.content.Context

/**
 * Created by Indri on 29/08/2017.
 */

class MusicTriviaApplication : Application(){

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
