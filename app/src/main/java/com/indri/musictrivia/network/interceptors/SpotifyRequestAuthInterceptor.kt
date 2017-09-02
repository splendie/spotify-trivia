package com.indri.musictrivia.network.interceptors

import android.content.Context
import android.text.TextUtils
import com.indri.musictrivia.network.HttpHeadersGuava
import com.indri.musictrivia.utils.PrefUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Indri on 01/09/2017.
 */
class SpotifyRequestAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val requestBuilder: Request.Builder = originalRequest.newBuilder()
                .addHeader(HttpHeadersGuava.ACCEPT, "application/json")
                .addHeader(HttpHeadersGuava.CONTENT_TYPE, "application/json")

        val originalHttpUrl = originalRequest.url()
        val urlBuilder = originalHttpUrl.newBuilder()

        val accessToken: String = PrefUtil.getString(PrefUtil.Key.KEY_SPOTIFY_ACCESS_TOKEN)
        if (!TextUtils.isEmpty(accessToken)) {
            requestBuilder.addHeader(HttpHeadersGuava.AUTHORIZATION, "Bearer "+accessToken)
        }

        val newRequest: Request = requestBuilder.url(urlBuilder.build()).build()
        return chain.proceed(newRequest)
    }
}