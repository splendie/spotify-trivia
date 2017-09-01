package com.indri.musictrivia.modules.login

import com.indri.musictrivia.R
import com.indri.musictrivia.utils.constants.GENRE_POP
import com.ruangguru.liveteachers.modules.BaseFragment
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment

/**
 * Created by Indri on 21/08/2017.
 */

@EFragment(R.layout.fragment_login)
open class GenreFragment : BaseFragment(), GenreContract.View {
    lateinit var mPresenter: GenreContract.Presenter

    @AfterViews
    fun init(){
        mPresenter.getPopularTracksByGenre(GENRE_POP)
    }
    override fun setPresenter(presenter: GenreContract.Presenter) {
        mPresenter = presenter
    }

    override fun showError(isShown: Boolean, errorMessage: String, errorLogMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLoadingIndicator(isActive: Boolean, message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}