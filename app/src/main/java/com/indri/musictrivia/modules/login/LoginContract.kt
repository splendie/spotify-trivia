package com.indri.musictrivia.modules.login

import com.indri.musictrivia.BasePresenter
import com.indri.musictrivia.BaseView
import com.spotify.sdk.android.authentication.AuthenticationRequest

/**
 * Created by Indri on 21/08/2017.
 */
interface LoginContract {

    interface View: BaseView<Presenter> {
        fun loginToSpotify()
    }

    interface Presenter: BasePresenter {
        fun getTokenAuthenticationRequest(): AuthenticationRequest
    }
}