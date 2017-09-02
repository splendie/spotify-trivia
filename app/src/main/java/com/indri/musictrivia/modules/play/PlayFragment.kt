package com.indri.musictrivia.modules.play

import com.indri.musictrivia.R
import com.indri.musictrivia.models.spotify.Track
import com.indri.musictrivia.utils.constants.GENRE_POP
import com.ruangguru.liveteachers.modules.BaseFragment
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import javax.inject.Inject

/**
 * Created by Indri on 02/09/2017.
 */

@EFragment(R.layout.fragment_play)
open class PlayFragment: BaseFragment(), PlayContract.View {

    @Inject
    lateinit var playPresenter: PlayContract.Presenter

    @AfterViews
    fun init() {
        playPresenter.getPopularTracksByGenre(GENRE_POP)
    }

    override fun setPresenter(presenter: PlayContract.Presenter) {
        playPresenter = presenter
    }

    override fun showTracks(trackList: List<Track>) {
        if (trackList.size > 0)
            showToast(trackList.get(0).name)
    }

    override fun setLoadingIndicator(isActive: Boolean, message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(isShown: Boolean, errorMessage: String, errorLogMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}