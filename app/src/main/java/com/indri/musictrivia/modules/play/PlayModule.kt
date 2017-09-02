package com.indri.musictrivia.modules.play

import com.indri.musictrivia.scopes.PlayScope
import com.indri.musictrivia.scopes.RepositoryScope
import dagger.Module
import dagger.Provides

/**
 * Created by Indri on 02/09/2017.
 */


@Module
class PlayModule(val view: PlayContract.View) {

    @Provides @PlayScope
    fun provideView(): PlayContract.View = view
}