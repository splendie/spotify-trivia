package com.indri.musictrivia.network

import android.content.Context
import android.os.Build
import android.util.Log
import com.indri.musictrivia.BuildConfig
import com.indri.musictrivia.network.interceptors.SpotifyRequestAuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import java.util.ArrayList
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext

/**
 * Created by Indri on 01/09/2017.
 */

@Module
class NetworkModule() {

    val SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1"

    @Provides @Singleton
    fun provideSpotifyRequestAuthInterceptor(): SpotifyRequestAuthInterceptor = SpotifyRequestAuthInterceptor()

    @Provides @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides @Singleton
    fun provideOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun provideCustomOkHttpClient(builder: OkHttpClient.Builder,
                                           logInterceptor: HttpLoggingInterceptor,
                                           authRequestInterceptor: SpotifyRequestAuthInterceptor): OkHttpClient {
        //Enable TLS v1.2 on pre lollipop
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            try {
                val sc = SSLContext.getInstance("TLSv1.2")
                sc.init(null, null, null)
                builder.sslSocketFactory(Tls12SocketFactory(sc.socketFactory))

                val cs = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .tlsVersions(TlsVersion.TLS_1_2)
                        .build()

                val specs = ArrayList<ConnectionSpec>()
                specs.add(cs)
                specs.add(ConnectionSpec.COMPATIBLE_TLS)
                specs.add(ConnectionSpec.CLEARTEXT)

                builder.connectionSpecs(specs)
            } catch (exc: Exception) {
                Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc)
            }

        }

        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.readTimeout(15, TimeUnit.SECONDS)
        builder.addInterceptor(authRequestInterceptor)
//        if (!BuildConfig.RELEASE) {
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logInterceptor)
//        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, context: Context): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
}