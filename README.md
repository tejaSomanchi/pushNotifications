
# Push Notifications

1.To import this library, Add the following line to your project's *build.gradle* at the end of repositories.
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```
2.To import this library, Add the following line to your app level *build.gradle* file.
```
implementation 'com.github.tejaSomanchi:pushNotifications:1.0.0

```
3.Add the following line to your *AndroidManifest.xml* for internet permission.

```
<uses-permission android:name="android.permission.INTERNET" />
```

4.To recieve the Push Notifications, Add the following lines to your *AndroidManifest.xml* file.

```
<service
    android:name="com.appyhigh.pushNotifications.MyFirebaseMessagingService"
    android:exported="false">
    <intent-filter>
        <action android:name="com.google.firebase.MESSAGING_EVENT" />
    </intent-filter>
</service>
<receiver
    android:name="com.appyhigh.pushNotifications.PushTemplateReceiver"
    android:exported="false"
    android:enabled="true">
</receiver>
```


5. CleverTap and Firebase can be used for push notifications in this library.

We have 4 types of push notifications P, B, L and D which are identified by the which parameter.
to can have two values fcmToken or topicName
P type notifications must open the play store. ("url": "com.appyhigh")
B type notifications must open the default browser. ("url": "https://youtube.com")
L type notifications must open the webview within the app. ("url": "https://youtube.com")
D type notification must open a specific page within the app. ("url": "AppName://ACTIVITYNAME")
Example data format to send for push notifications

{
  "to": "/topics/Appname",
  "data": {
    "title": "Krissh 3",
    "message": "See hritiks best action super hero movie only on liveTv",
    "image": "https://img.youtube.com/vi/1N_zzi2ad04/hqdefault.jpg",
    "url": "https://www.youtube.com/watch?v=ZpuY57qrZs8",
    "which": "L"
  }
}
Call checkForNotifications from your MainActivity
checkForNotifications(
            context: Context,
            intent: Intent,
            webViewActivity: Class<out Activity?>?
        )
Example
MyFirebaseMessaging.checkForNotifications(context = this, intent = intent, webViewActivity = WebViewActivity::class.java)


