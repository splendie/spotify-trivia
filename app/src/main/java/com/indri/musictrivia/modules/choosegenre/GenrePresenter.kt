package com.indri.musictrivia.modules.login

import android.content.Context
import java.util.HashMap

/**
 * Created by Indri on 21/08/2017.
 */

class GenrePresenter(val context: Context, val view: GenreContract.View) : GenreContract.Presenter {

    init {
        view.setPresenter(this)
    }


    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}