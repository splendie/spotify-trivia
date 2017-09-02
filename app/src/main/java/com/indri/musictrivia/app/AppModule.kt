package com.indri.musictrivia.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Indri on 01/09/2017.
 */

@Module
class AppModule(val context: Context) {

    @Provides @Singleton
    fun provideContext(): Context = context
}