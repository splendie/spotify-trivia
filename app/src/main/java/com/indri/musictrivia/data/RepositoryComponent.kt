package com.indri.musictrivia.data

import android.content.Context
import com.google.gson.Gson
import com.indri.musictrivia.SingletonComponent
import com.indri.musictrivia.data.recommendations.RecommendationsRepository
import com.indri.musictrivia.data.recommendations.RecommendationsRepositoryModule
import com.indri.musictrivia.scopes.RepositoryScope
import dagger.Component

/**
 * Created by Indri on 02/09/2017.
 */

@RepositoryScope
@Component(
        dependencies = arrayOf(SingletonComponent::class),
        modules = arrayOf(RepositoryModule::class,
                RecommendationsRepositoryModule::class))

interface RepositoryComponent {
    fun context(): Context
    fun gson(): Gson
    fun recommendationsRepository(): RecommendationsRepository

}