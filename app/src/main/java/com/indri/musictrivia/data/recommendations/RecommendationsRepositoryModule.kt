package com.indri.musictrivia.data.recommendations

import com.indri.musictrivia.scopes.RepositoryScope
import com.indri.musictrivia.data.recommendations.remote.RecommendationsRemoteSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Indri on 02/09/2017.
 */

@Module
class RecommendationsRepositoryModule {

    @Provides @RepositoryScope
    fun provideRemoteDataSource(retrofit: Retrofit): RecommendationsRemoteSource = RecommendationsRemoteSource(retrofit)
}