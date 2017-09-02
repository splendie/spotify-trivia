package com.indri.musictrivia.network.interfaces.spotify

import com.indri.musictrivia.models.spotify.Recommendations
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Indri on 01/09/2017.
 */
interface RecommendationsApi {

    /**
     * Create a playlist-style listening experience based on seed artists, tracks and genres.
     *
     * @param options Optional parameters. For list of available parameters see
     *                <a href="https://developer.spotify.com/web-api/get-recommendations/">endpoint documentation</a>
     * @return Recommendations response object
     */
    @GET("/recommendations")
    fun getRecommendations(@QueryMap options: Map<String, Object>): Recommendations

}