package com.indri.musictrivia.modules.login

import android.widget.ImageButton
import com.indri.musictrivia.R
import com.indri.musictrivia.modules.play.PlayActivity
import com.indri.musictrivia.modules.play.PlayActivity_
import com.ruangguru.liveteachers.modules.BaseFragment
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

/**
 * Created by Indri on 21/08/2017.
 */

@EFragment(R.layout.fragment_choose_genre)
open class GenreFragment : BaseFragment(), GenreContract.View {
    lateinit var mPresenter: GenreContract.Presenter

    @AfterViews
    fun init() {
    }

    @Click(R.id.btn_genre)
    fun goToPlayScreen(){
        PlayActivity_.intent(activity).start()
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