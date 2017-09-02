package com.indri.musictrivia.modules.login

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.indri.musictrivia.R
import com.indri.musictrivia.utils.constants.AUTH_REQUEST
import com.indri.musictrivia.utils.PrefUtil
import com.ruangguru.liveteachers.modules.BaseFragment
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EFragment

/**
 * Created by Indri on 21/08/2017.
 */

@EFragment(R.layout.fragment_login)
open class LoginFragment : BaseFragment(), LoginContract.View {
    lateinit var mPresenter: LoginContract.Presenter

    lateinit var mAccessToken: String
    lateinit var mAccessCode: String

    @Click(R.id.button_login)
    override fun loginToSpotify() {
        val request: AuthenticationRequest = mPresenter?.getTokenAuthenticationRequest()
        AuthenticationClient.openLoginActivity(activity, AUTH_REQUEST, request)
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

    override fun showError(isShown: Boolean, errorMessage: String, errorLogMessage: String) {
        if (isShown)
            showToast(errorMessage)
        Log.d("iy", errorLogMessage)
    }

    override fun setLoadingIndicator(isActive: Boolean, message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val response: AuthenticationResponse = AuthenticationClient.getResponse(resultCode, data);

            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    mAccessToken = response.accessToken
                    PrefUtil.put(PrefUtil.Key.KEY_SPOTIFY_ACCESS_TOKEN, mAccessToken)
                    GenreActivity_.intent(activity).start()
                }
                AuthenticationResponse.Type.CODE -> {
                    mAccessCode = response.code
                    PrefUtil.put(PrefUtil.Key.KEY_SPOTIFY_CODE, mAccessCode)
                    GenreActivity_.intent(activity).start()
                }
                AuthenticationResponse.Type.ERROR -> {
                    showError(true, response.error, response.code)
                }
            }
        }
    }
}