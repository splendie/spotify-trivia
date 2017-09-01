package com.indri.musictrivia.network.spotify.interfaces

import com.indri.musictrivia.models.spotify.UserPrivate
import com.indri.musictrivia.models.spotify.UserPublic
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Indri on 01/09/2017.
 */
interface UserApi {

    /**
     * Get the currently logged in user profile information.
     * The contents of the User object may differ depending on application's scope.
     *
     * @see [Get Current User's Profile](https://developer.spotify.com/web-api/get-current-users-profile/)
     */
    @GET("/me")
    fun getMe(): Observable<Response<UserPrivate>>


    /**
     * Get a user's profile information.
     *
     * @param userId The user's User ID
     * @return The user's profile information.
     * @see <a href="https://developer.spotify.com/web-api/get-users-profile/">Get User's Public Profile</a>
     */
    @GET("/users/{id}")
    fun getUser(@Path("id") userId: String ): UserPublic

}