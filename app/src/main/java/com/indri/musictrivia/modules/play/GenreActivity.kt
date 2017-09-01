package com.indri.musictrivia.modules.login

import android.os.Bundle
import com.indri.musictrivia.R
import com.ruangguru.liveteachers.FragmentHostActivity
import org.androidannotations.annotations.EActivity



/**
 * Created by Indri on 21/08/2017.
 */

@EActivity(R.layout.fragment_host)
open class GenreActivity : FragmentHostActivity() {

    lateinit var presenter: GenrePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) initFragment()
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    fun initFragment(){
        currentFragment = GenreFragment_.builder().build()
    }

    fun initPresenter(){
        presenter = GenrePresenter(this, currentFragment as GenreContract.View)
    }
}