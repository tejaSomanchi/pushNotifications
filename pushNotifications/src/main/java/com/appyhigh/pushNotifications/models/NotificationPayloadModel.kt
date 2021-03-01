package com.appyhigh.pushNotifications.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotificationPayloadModel(
    @SerializedName("notificationType")
    @Expose
    var notificationType: String? = "",

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("messageBody")
    @Expose
    var messageBody: String? = null,

    @SerializedName("which")
    @Expose
    var which: String? = null,

    @SerializedName("link")
    @Expose
    var link: String? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null

)