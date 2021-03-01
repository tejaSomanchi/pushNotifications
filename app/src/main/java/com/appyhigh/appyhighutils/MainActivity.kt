package com.appyhigh.appyhighutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val myFirebaseMessagingService = MyFirebaseMessagingService()
//        myFirebaseMessagingService.getAppName(this)
//        myFirebaseMessagingService.checkForNotifications(
//            this, intent,
//            MainActivity::class.java,
//            MainActivity::class.java, ""
//        )
    }
}