
# Push Notifications

# Table of contents

- [Installation](#installation)
- [Template Types](#template-types)

# Installation

[(Back to top)](#table-of-contents)

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
implementation 'com.github.

```
3.Add the following line to your *AndroidManifest.xml* for internet permission.

```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

```
4.If you are using **CleverTap** for push notifications, then add the following lines to your *AndroidManifest.xml* file.

```
 <meta-data
    android:name="CLEVERTAP_ACCOUNT_ID"
    android:value="**your_accountId**"/>
<meta-data
    android:name="CLEVERTAP_TOKEN"
    android:value="**your_token**"/>
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

# Template Types

[(Back to top)](#table-of-contents)

## Basic Template

Basic Template is the basic push notification received on apps.
<br/>(Expanded and unexpanded example)<br/><br/>
![Basic with color](https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/basic%20color.png)


## Rating Template

Rating template lets your users give you feedback, this feedback is captured and if five starts is clicked then [playstore in-app review](https://developer.android.com/guide/playcore/in-app-review) is displayed inside the app.<br/>(Expanded and unexpanded example)<br/>

![Rating](https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/rating.gif)


## Zero Bezel Template

The Zero Bezel template ensures that the background image covers the entire available surface area of the push notification. All the text is overlayed on the image.<br/>(Expanded and unexpanded example)<br/>

![Zero Bezel](https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/zerobezel.gif)




We have 4 types of push notifications P, B, L and D which are identified by the which parameter.
to can have two values fcmToken or topicName
- P type notifications must open the play store. ("url": "com.appyhigh")
- B type notifications must open the default browser. ("url": "https://youtube.com")
- L type notifications must open the webview within the app. ("url": "https://youtube.com")
- D type notification must open a specific page within the app. ("url": "AppName://ACTIVITYNAME")

### Example data format to send for push notifications
```
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
```

Call checkForNotifications from your MainActivity
```
checkForNotifications(context: Context, intent: Intent, webViewActivity: Class<out Activity?>?)
```
### Example
```
MyFirebaseMessaging.checkForNotifications(context = this, intent = intent, webViewActivity = WebViewActivity::class.java)
```

