package com.indri.musictrivia.modules.play

import com.indri.musictrivia.BasePresenter
import com.indri.musictrivia.BaseView
import com.indri.musictrivia.models.spotify.Track

/**
 * Created by Indri on 02/09/2017.
 */
interface PlayContract {
    interface View: BaseView<Presenter> {
        fun showTracks(trackList: List<Track>)
    }

    interface Presenter: BasePresenter {
        fun getPopularTracksByGenre(genre: String)

    }
}