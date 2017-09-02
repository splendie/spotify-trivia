package com.indri.musictrivia.app

import android.app.Application
import android.content.Context
import com.indri.musictrivia.DaggerSingletonComponent
import com.indri.musictrivia.SingletonComponent
import com.indri.musictrivia.data.DaggerRepositoryComponent
import com.indri.musictrivia.data.RepositoryComponent

/**
 * Created by Indri on 29/08/2017.
 */

class MusicTriviaApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    lateinit var singletonComponent: SingletonComponent
    lateinit var repositoryComponent: RepositoryComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        val appModule: AppModule = AppModule(applicationContext)

        singletonComponent = DaggerSingletonComponent.builder().appModule(appModule).build()
        repositoryComponent = DaggerRepositoryComponent.builder().singletonComponent(singletonComponent).build()
    }

}
