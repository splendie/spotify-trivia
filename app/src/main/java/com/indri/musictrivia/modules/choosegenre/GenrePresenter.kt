package com.indri.musictrivia.modules.login

import android.content.Context
import com.indri.musictrivia.utils.PrefUtil
import okhttp3.Headers
import okhttp3.Request
import java.util.HashMap

/**
 * Created by Indri on 21/08/2017.
 */

class GenrePresenter(val context: Context, val view: GenreContract.View) : GenreContract.Presenter {

    init {
        view.setPresenter(this)
    }


    override fun getPopularTracksByGenre(genre: String) {
        val options = HashMap<String, Any>()
        options.put("seed_genres", genre)
        options.put("min_popularity", 80)


    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}