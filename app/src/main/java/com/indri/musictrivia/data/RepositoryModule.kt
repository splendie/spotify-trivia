package com.indri.musictrivia.data

import com.google.gson.Gson
import com.indri.musictrivia.scopes.RepositoryScope
import dagger.Module
import dagger.Provides

/**
 * Created by Indri on 02/09/2017.
 */
@Module
class RepositoryModule {

    @Provides @RepositoryScope
    fun provideGson(): Gson = Gson()
}