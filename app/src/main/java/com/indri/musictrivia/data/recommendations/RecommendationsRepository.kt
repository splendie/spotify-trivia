package com.indri.musictrivia.data.recommendations

import android.content.Context
import com.indri.musictrivia.scopes.RepositoryScope
import com.indri.musictrivia.data.recommendations.remote.RecommendationsRemoteSource
import com.indri.musictrivia.models.spotify.Track
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

/**
 * Created by Indri on 02/09/2017.
 */

@RepositoryScope
class RecommendationsRepository @Inject constructor(val context: Context, val remoteDataSource: RecommendationsRemoteSource) {

    fun getPopularTracksByGenre(genre: String): Observable<List<Track>> {
        return remoteDataSource.getPopularTracksByGenre(genre)
                .flatMap(Function { t ->
                    if (t.isSuccessful) {
                        return@Function Observable.just(t.body().tracks)
                    } else {
                        return@Function Observable.just(t.body().tracks)
                    }
                })
    }
}