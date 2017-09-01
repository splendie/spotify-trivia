package com.ruangguru.liveteachers

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.indri.musictrivia.R
import com.ruangguru.liveteachers.modules.BaseFragment


import org.androidannotations.annotations.EActivity

/**
 * Created by USER on 03/01/2017.

 */

@EActivity(R.layout.fragment_host)
open class FragmentHostActivity : AppCompatActivity() {

    lateinit var currentFragment: BaseFragment

    companion object {
        private val FRAGMENT_ARG = "current_fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) currentFragment = supportFragmentManager.getFragment(savedInstanceState, FRAGMENT_ARG) as BaseFragment
        if (currentFragment != null) {
            changeFragment(currentFragment)
        }
    }

    fun changeFragment(fragment: Fragment) {
        val fr = supportFragmentManager.findFragmentById(R.id.container)
        if (fr == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            currentFragment!!.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        supportFragmentManager.putFragment(outState, FRAGMENT_ARG, currentFragment)
    }
}
