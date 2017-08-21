package com.indri.musictrivia

/**
 * Created by Indri on 21/08/2017.
 */
interface BaseView<T> {

    /** Set presenter here  */
    fun setPresenter(presenter: T)

    /**
     * Throw event from (mostly) backend operations when some
     * error occured.

     * @param isShown         boolean determining if the error should be shown. Don't show error message if not needed.
     * *
     * @param errorMessage
     * *
     * @param errorLogMessage
     */
    fun showError(isShown: Boolean, errorMessage: String, errorLogMessage: String)

    /** Determine if view should show loading indicator  */
    fun setLoadingIndicator(isActive: Boolean, message: String)
}
