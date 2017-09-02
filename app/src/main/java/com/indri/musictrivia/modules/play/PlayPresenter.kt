package com.indri.musictrivia.modules.play

import android.content.Context
import com.indri.musictrivia.data.recommendations.RecommendationsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Indri on 02/09/2017.
 */
class PlayPresenter @Inject constructor(val context: Context, val view: PlayContract.View, val repository: RecommendationsRepository) :PlayContract.Presenter {

    val disposables = CompositeDisposable()

    override fun getPopularTracksByGenre(genre: String) {

        val disposable: Disposable = repository.getPopularTracksByGenre(genre)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    view.showTracks(it)
                }

        disposables.add(disposable)
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        disposables.clear()
    }
}