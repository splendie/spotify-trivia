package com.indri.musictrivia.modules.login

import android.content.Context
import android.net.Uri
import com.indri.musictrivia.R
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
/**
 * Created by Indri on 21/08/2017.
 */

class LoginPresenter constructor(val context: Context, val view: LoginContract.View): LoginContract.Presenter{
    init {
        view.setPresenter(this)
    }

    lateinit var mAccessToken: String
    lateinit var mAccessCode: String

    val scopes = arrayOf(
            "playlist-read-private",
            "user-library-read",
            "user-top-read",
            "user-read-email",
            "user-read-private",
            "user-follow-read"
    )


    override fun getTokenAuthenticationRequest(): AuthenticationRequest {
        return AuthenticationRequest.Builder(context.getString(R.string.CLIENT_ID), AuthenticationResponse.Type.TOKEN, getRedirectUri().toString())
                .setShowDialog(true)
                .setScopes(scopes)
                .build()
    }

    override fun getCodeAuthenticationRequest(): AuthenticationRequest {
        return AuthenticationRequest.Builder(context.getString(R.string.CLIENT_ID), AuthenticationResponse.Type.CODE, getRedirectUri().toString())
                .setShowDialog(true)
                .setScopes(scopes)
                .build()
    }

    private fun getRedirectUri(): Uri {
        return Uri.Builder()
                .scheme(context.getString(R.string.REDIRECT_SCHEME))
                .authority(context.getString(R.string.REDIRECT_HOST))
                .build()
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}