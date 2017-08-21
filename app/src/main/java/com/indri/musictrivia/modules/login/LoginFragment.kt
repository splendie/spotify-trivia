package com.indri.musictrivia.modules.login

import android.content.Intent
import com.indri.musictrivia.R
import com.indri.musictrivia.utils.AUTH_TOKEN_REQUEST_CODE
import com.ruangguru.liveteachers.modules.BaseFragment
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import kotlinx.android.synthetic.main.fragment_login.*
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EFragment

/**
 * Created by Indri on 21/08/2017.
 */

@EFragment(R.layout.fragment_login)
open class LoginFragment : BaseFragment(), LoginContract.View {
    lateinit var mPresenter: LoginContract.Presenter

    lateinit var mAccessToken: String

    @Click(R.id.button_login)
    override fun loginToSpotify() {
        val request: AuthenticationRequest = mPresenter?.getTokenAuthenticationRequest()
        AuthenticationClient.openLoginActivity(activity, AUTH_TOKEN_REQUEST_CODE, request)
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

    override fun showError(isShown: Boolean, errorMessage: String, errorLogMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLoadingIndicator(isActive: Boolean, message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val response: AuthenticationResponse = AuthenticationClient.getResponse(resultCode, data);

        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            mAccessToken = response.accessToken
        }
    }
}