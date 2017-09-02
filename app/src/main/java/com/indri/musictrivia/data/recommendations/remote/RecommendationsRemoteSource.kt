package com.indri.musictrivia.data.recommendations.remote

import com.indri.musictrivia.models.spotify.Recommendations
import com.indri.musictrivia.network.interfaces.spotify.RecommendationsApi
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by Indri on 02/09/2017.
 */

class RecommendationsRemoteSource(val retrofit: Retrofit) {

    fun getPopularTracksByGenre(genre: String): Observable<Response<Recommendations>> {
        val options: MutableMap<String, Any> = HashMap()
        options.put("seed_genres", genre)
        options.put("min_popularity", 80)
        return retrofit.create(RecommendationsApi::class.java!!).getRecommendations(options)
    }

}