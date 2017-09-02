package com.indri.musictrivia

import android.content.Context
import com.indri.musictrivia.app.AppModule
import com.indri.musictrivia.network.NetworkModule
import com.indri.musictrivia.network.interceptors.SpotifyRequestAuthInterceptor
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Indri on 01/09/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface SingletonComponent {
    fun context(): Context
    fun retrofit(): Retrofit
    fun requestInterceptor(): SpotifyRequestAuthInterceptor
}