package com.indri.musictrivia.modules.play

import android.os.Bundle
import com.indri.musictrivia.R
import com.ruangguru.liveteachers.FragmentHostActivity
import org.androidannotations.annotations.EActivity
import javax.inject.Inject

/**
 * Created by Indri on 02/09/2017.
 */

@EActivity(R.layout.fragment_host)
open class PlayActivity: FragmentHostActivity(){

    @Inject
    lateinit var presenter: PlayPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        initFragment()
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    fun initFragment() {
        currentFragment = PlayFragment_.builder().build()
    }

    fun initPresenter() {

    }
}