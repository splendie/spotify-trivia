package com.indri.musictrivia.modules.login

import android.os.Bundle
import com.indri.musictrivia.R
import com.ruangguru.liveteachers.FragmentHostActivity
import org.androidannotations.annotations.EActivity



/**
 * Created by Indri on 21/08/2017.
 */

@EActivity(R.layout.fragment_host)
open class LoginActivity: FragmentHostActivity() {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) initFragment()
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    fun initFragment(){
        currentFragment = LoginFragment_.builder().build()
    }

    fun initPresenter(){
        presenter = LoginPresenter(this, currentFragment as LoginContract.View)
    }
}