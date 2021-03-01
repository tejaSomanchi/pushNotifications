package com.appyhigh.appyhighutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appyhigh.pushNotifications.MyFirebaseMessagingService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myFirebaseMessagingService = MyFirebaseMessagingService()
        myFirebaseMessagingService.checkForNotifications(
            this, intent,
            MainActivity::class.java,
            MainActivity::class.java, ""
        )
    }
}