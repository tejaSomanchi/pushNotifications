package com.appyhigh.pushNotifications.apiclient

import com.appyhigh.pushNotifications.models.NotificationPayloadModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIInterface {

    @GET("getNotifications?")
    fun getNotifications(
        @Query("packageName") packageName: String?
    ): Observable<ArrayList<NotificationPayloadModel>>
}