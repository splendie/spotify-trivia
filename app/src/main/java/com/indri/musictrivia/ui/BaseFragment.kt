package com.ruangguru.liveteachers.modules

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast

open class BaseFragment : Fragment() {

    protected fun setToolbar(toolbar : Toolbar){
        (activity as AppCompatActivity?)?.setSupportActionBar(toolbar)
    }

    protected fun setToolbarTitle(title : String){
        (activity as AppCompatActivity?)?.supportActionBar?.title = title
    }

    protected fun setBackArrow(){
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}