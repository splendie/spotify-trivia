package com.indri.musictrivia.modules.login

import android.content.Context
import com.indri.musictrivia.utils.PrefUtil
import kaaes.spotify.webapi.android.SpotifyApi
import kaaes.spotify.webapi.android.SpotifyService
import okhttp3.Headers
import okhttp3.Request
import java.util.HashMap

/**
 * Created by Indri on 21/08/2017.
 */

class GenrePresenter(val context: Context, val view: GenreContract.View) : GenreContract.Presenter {

    lateinit var mAuthHeader: Headers
    val spotifyApi: SpotifyApi = SpotifyApi()
    var spotify: SpotifyService

    init {
        view.setPresenter(this)
        spotifyApi.setAccessToken(PrefUtil.getString(PrefUtil.Key.KEY_SPOTIFY_TOKEN.name))
        spotify = spotifyApi.getService()
    }


    override fun getPopularTracksByGenre(genre: String) {
        val options = HashMap<String, Any>()
        options.put("seed_genres", "pop")
        options.put("min_popularity", 80)


        val payload = spotify.getRecommendations(options)

        val request = Request.Builder()
                .get()
                .headers(mAuthHeader)
                .url("https://api.spotify.com/v1/recommendations?seed_artists=4cJKxS7uOPhwb5UQ70sYpN,6UUrUCIZtQeOf8tC0WuzRy")
                .build()

    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}