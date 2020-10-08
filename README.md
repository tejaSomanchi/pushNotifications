
# Push Notifications & InApp Notifications
- [Push Notifications](#push-notifications)
- [InApp Notifications](#inApp-notifications)

# Push Notifications

# Table of contents

- [Installation](#installation)
- [Template Types](#template-types)
- [Template Keys](#template-keys)
- [Functions](#functions)

# Installation

[(Back to top)](#table-of-contents)

1.To import this library, Add the following line to your project's *build.gradle* at the end of repositories.
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

```
2.To import this library, Add the following line to your app level *build.gradle* file.
```groovy
implementation 'com.github.

```
3.Add the following line to your *AndroidManifest.xml* for internet permission.

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

```
4.If you are using **CleverTap** for push notifications, then add the following lines to your *AndroidManifest.xml* file.

```xml
 <meta-data
    android:name="CLEVERTAP_ACCOUNT_ID"
    android:value="**your_accountId**"/>
<meta-data
    android:name="CLEVERTAP_TOKEN"
    android:value="**your_token**"/>
```

4.To recieve the Push Notifications, Add the following lines to your *AndroidManifest.xml* file.

```xml
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

<img src="https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/basic%20color.png" width="300" />


## Rating Template

Rating template lets your users give you feedback, this feedback is captured and if five starts is clicked then [playstore in-app review](https://developer.android.com/guide/playcore/in-app-review) is displayed inside the app.<br/>(Expanded and unexpanded example)<br/>

<img src="https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/rating.gif" width="300" />


## Bezel Template

The Bezel template ensures that the background image covers the entire available surface area of the push notification. All the text is overlayed on the image.<br/>(Expanded and unexpanded example)<br/>

### Zero Bezel Template

<img src="https://github.com/CleverTap/PushTemplates/blob/0.0.4/screens/zerobezel.gif" width="300" />

### One Bezel Template

<img src="https://user-images.githubusercontent.com/69451072/94699515-03c24200-0358-11eb-9b29-ec3d22e40890.png" width="300" />

# Template Keys

[(Back to top)](#table-of-contents)

We have 4 types of push notifications P, B, L and D which are identified by the which parameter.
- P type notifications must open the play store. ("url": "com.appyhigh")
- B type notifications must open the default browser. ("url": "https://youtube.com")
- L type notifications must open the webview within the app. ("url": "https://youtube.com")
- D type notification must open a specific page within the app. ("url": "AppName://ACTIVITYNAME")

### Basic Template

 Basic Template Keys | Required | Description 
 ---:|:---:|:---| 
 target_activity | Required | Activity that should be opened when notification is clicked
 title | Required | Title 
 message | Required | Message 
 messageBody | Required | Message line when Notification is expanded
 image | Optional | Image in url
 which | Optional | Value - `P`/`B`/`L`/`D`
 link | Required if 'which' is entered | url for 'which' type
 large_icon | Optional | Large Icon 
 small_icon | Optional | Small Icon
 

### Rating Template

 Rating Template Keys | Required | Description 
 ---:|:---:|:--- 
 notificationType | Required  | Value - `R`
 target_activity | Required | Activity that should be opened when notification is clicked
 title | Required | Title 
 message | Required | Message 
 messageBody | Required | Message line when Notification is expanded
 image | Required | Image in url
 which | Optional | Value - `P`/`B`/`L`/`D`
 link | Required if 'which' is entered | url for 'which' type
 large_icon | Optional | Large Icon 
 small_icon | Optional | Small Icon
 meta_clr | Optional | Color for appname,timestamp in HEX (default - #A6A6A6)
 title_clr | Optional | Title Color in HEX (default - ##000000)
 message_clr | Optional | Message Color in HEX (default - #000000)
 pt_bg | Required | Background Color in HEX (default - #FFFFFF)
 
### Zero Bezel Template
 
 Zero Bezel Template Keys | Required | Description 
 ---:|:---:|:--- 
 notificationType | Required  | Value - `Z`
 target_activity | Required | Activity that should be opened when notification is clicked
 title | Required | Title 
 message | Required | Message 
 messageBody | Required | Message line when Notification is expanded
 image | Required | Image in url
 which | Optional | Value - `P`/`B`/`L`/`D`
 link | Required if 'which' is entered | url for 'which' type
 large_icon | Optional | Large Icon 
 small_icon | Optional | Small Icon
 meta_clr | Optional | Color for appname,timestamp in HEX (default - #A6A6A6)
 title_clr | Optional | Title Color in HEX (default - ##000000)
 message_clr | Optional | Message Color in HEX (default - #000000)
 pt_bg | Required | Background Color in HEX (default - #FFFFFF)
 
 ### One Bezel Template
 
 One Bezel Template Keys | Required | Description 
 ---:|:---:|:--- 
 notificationType | Required  | Value - `O`
 target_activity | Required | Activity that should be opened when notification is clicked
 title | Required | Title 
 message | Required | Message 
 messageBody | Required | Message line when Notification is expanded
 image | Required | Image in url
 which | Optional | Value - `P`/`B`/`L`/`D`
 link | Required if 'which' is entered | url for 'which' type
 large_icon | Optional | Large Icon 
 small_icon | Optional | Small Icon
 meta_clr | Optional | Color for appname,timestamp in HEX (default - #A6A6A6)
 title_clr | Optional | Title Color in HEX (default - ##000000)
 message_clr | Optional | Message Color in HEX (default - #000000)
 pt_bg | Required | Background Color in HEX (default - #FFFFFF)
  
  
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

# Functions

[(Back to top)](#table-of-contents)

1.Call *checkForNotifications* method in your MainActivity to recieve data from notifications
```
checkForNotifications(context: Context, intent: Intent, webViewActivity: Class<out Activity?>?,activityToOpen: Class<out Activity?>?,intentParam: String)
```
**Note:**

1.All the parameters are required.

2.Empty string - `""` should be given as default value for intentParam.

### Example
```
MyFirebaseMessaging.checkForNotifications(context = this, intent = intent, webViewActivity = WebViewActivity::class.java, activityToOpen = MainActivity::class.java,"")
```

# InApp Notifications

[(Back to top)](#push-notifications--inApp-notifications)

# Table of contents

- [Installation](#installation)
- [Firebase](#firebase)
- [CleverTap](#cleverTap)

# Installation

[(Back to top)](#table-of-contents-1)

1.To import this library, Add the following line to your project's *build.gradle* at the end of repositories.
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

```
2.To import this library, Add the following line to your app level *build.gradle* file.
```groovy
implementation 'com.github.

```

3.If you are using **Firebase** for InApp Notifications, then add the following lines to your app level *build.gradle* file.
```groovy
implementation 'com.google.firebase:firebase-inappmessaging-display:19.1.1' (#Recommended latest version)
`
``
4.If you are using **CleverTap** for InApp Notifications, then add the following lines to your app level *build.gradle* file.
```groovy
implementation 'com.clevertap.android:clevertap-android-sdk:3.7.2' (#Recommended latest version)
implementation 'androidx.fragment:fragment:1.1.0'
```


3.Add the following line to your *AndroidManifest.xml* for internet permission.

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

```

4.If you are using **CleverTap** for InApp Notifications, then add the following lines to your *AndroidManifest.xml* file.

```xml
 <meta-data
    android:name="CLEVERTAP_ACCOUNT_ID"
    android:value="**your_accountId**"/>
<meta-data
    android:name="CLEVERTAP_TOKEN"
    android:value="**your_token**"/>
<activity
    android:name="com.clevertap.android.sdk.InAppNotificationActivity"
    android:theme="@android:style/Theme.Translucent.NoTitleBar"
    android:configChanges="orientation|keyboardHidden"/>

<meta-data
    android:name="CLEVERTAP_INAPP_EXCLUDE"
    android:value="**YourSplashActivity1**, **YourSplashActivity2**" /> 
```

We have 4 types of InApp notifications P, B, L and D which are identified by the which parameter.
- P type notifications must open the play store. ("url": "com.appyhigh")
- B type notifications must open the default browser. ("url": "https://youtube.com")
- L type notifications must open the webview within the app. ("url": "https://youtube.com")
- D type notification must open a specific page within the app. ("url": "AppName://ACTIVITYNAME")

# Firebase

[(Back to top)](#table-of-contents-1)

1.Create a campaign in Firebase InApp Messaging console.

2.For action urls 
	- Enter deeplinks of the app to open a particular activity inside the app.
	- Enter urls to redirect to playstore or browser.
	
**Note**

1.For Deep Links, do not forget to add the following lines inside the *activity* of *AndroidManifest.xml*.
```xml
<intent-filter android:autoVerify="true">
    <action android:name="android.intent.action.VIEW"/>
    <category android:name="android.intent.category.DEFAULT"/>
    <category android:name="android.intent.category.BROWSABLE"/>
    <data
	android:host="your domain link which you created in firebase console**"
	android:scheme="https"/>
</intent-filter>
```

# CleverTap

[(Back to top)](#table-of-contents-1)

1.Create a mobile-inApp campaign in CleverTap console,

2.For Buttons, enter the custom key-value pairs.

Custom Keys | Required | Description 
 ---:|:---:|:--- 
 which | Optional | Value - `P`/`B`/`L`/`D`
 link | Required if 'which' is entered | url for 'which' type
 title | Optional | title to pass for webViewActivity
 
3.To recieve InApp notifications, follow any of the two methods

### Import the inAppButtonClickListener from Library
1.Call the *setListener* method in the activity to handle the inApp Notification

```
setListener(context: Context, webViewActivityToOpen: Class<out Activity?>?, activityToOpen: Class<out Activity?>?, intentParam: String)

```
**Note:**

1.All the parameters are required.

2.Empty string - `""` should be given as default value for intentParam.

#### Example
```
MyFirebaseMessagingService myFirebaseMessagingService = new MyFirebaseMessagingService();
myFirebaseMessagingService.setListener(context = this, webViewActivity = WebViewActivity::class.java, activityToOpen = MainActivity::class.java,"");
```
### Implement the inAppButtonClickListener explicitly without importing it from library.

1.Make sure your activity implements the InAppNotificationButtonListener and override the following method
```
public class MainActivity extends AppCompatActivity implements InAppNotificationButtonListener {
	@Override
	public void onInAppButtonClick(HashMap<String, String> hashMap) {
	  if(hashMap != null){
	    //Read the values
	  }
	}
}
```

2.Convert the recieved hashmap to Bundle in the above *if condition*.

3.Set the InAppNotificationButtonListener using the following code in your activity.
```
CleverTapAPI.getDefaultInstance(context).setInAppNotificationButtonListener(this);

```

3.Call the *checkForInAppNotifications* method inside the *onInAppButtonClick* method to handle the recieved data.
```
checkForInAppNotifications(context: Context, extras: Bundle, webViewActivity: Class<out Activity?>?,activityToOpen: Class<out Activity?>?,intentParam: String)
```

#### Example
```Kotlin
class MainActivity : AppCompatActivity(), InAppNotificationButtonListener {
	override fun onInAppButtonClick(hashMap: HashMap<String?, String?>) 
	{
		val extras = Bundle()
		for ((key, value) in hashMap.entries) {
		    extras.putString(key, value)
		    Log.d("extras", "-> $extras")
		}
		checkForInAppNotifications(this, extras, WebViewActivityToOpen, activityToOpen, intentParam)
    	}
	
	override fun onCreate(savedInstanceState: Bundle?) 
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		CleverTapAPI.getDefaultInstance(context)!!.setInAppNotificationButtonListener(this)
	}
    }
}

```




