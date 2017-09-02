package com.indri.musictrivia.modules.play

import com.indri.musictrivia.data.RepositoryComponent
import com.indri.musictrivia.scopes.PlayScope
import dagger.Component

/**
 * Created by Indri on 02/09/2017.
 */

@PlayScope
@Component(dependencies = arrayOf(RepositoryComponent::class),
        modules = arrayOf(PlayModule::class))
interface PlayComponent {
    fun inject(activity: PlayActivity)
}