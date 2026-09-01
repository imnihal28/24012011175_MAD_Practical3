# Practical 3: Implicit and Explicit Intent

## Aim

Create an Android application which demonstrates implicit and explicit Intent.

---

## Application Demo

<table width="100%">
<tr>
<td width="50%" valign="top">

### 🎥 Demo

https://github.com/user-attachments/assets/b6b26a51-c03d-41a2-8d00-3620a9bb6885
</td>

<td width="50%" valign="top">

### 📝 Steps

1. **Web Browse**
2. **Phone Call**
3. **Call Log**
4. **Gallery**
5. **Camera**
6. **Set Alarm**
7. **Login Navigation**

</td>
</tr>
</table>

---

## Application Logic

### 1. Implicit Intent

Implicit intents allow the app to request an action from another app on the device without knowing which app will handle it.

```kotlin
// Browsing a URL
findViewById<Button>(R.id.btnBrowse).setOnClickListener {

    val url = findViewById<EditText>(R.id.edtWeb)
        .text
        .toString()

    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
        startActivity(it)
    }
}

// Opening Dialer with a Number
findViewById<Button>(R.id.btnCall).setOnClickListener {

    val number = findViewById<EditText>(R.id.edtPhone)
        .text
        .toString()

    Intent(Intent.ACTION_DIAL).apply {
        data = "tel:$number".toUri()
    }.also {
        startActivity(it)
    }
}
```

- **Action View**: Used for browsing web content.
- **Action Dial**: Opens the dialer with the provided phone number using `tel:` URI.

```kotlin
// Opening Call Log
findViewById<Button>(R.id.btnCallLog).setOnClickListener {

    Intent(
        Intent.ACTION_VIEW,
        CallLog.Calls.CONTENT_URI
    ).also {
        startActivity(it)
    }
}

// Opening Gallery
findViewById<Button>(R.id.btnGallery).setOnClickListener {

    Intent(
        Intent.ACTION_PICK,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    ).also {
        startActivity(it)
    }
}

// Opening Camera
findViewById<Button>(R.id.btnCamera).setOnClickListener {

    Intent(
        MediaStore.ACTION_IMAGE_CAPTURE
    ).also {
        startActivity(it)
    }
}
```

- **Call Log**: Opens the device call history.
- **Gallery**: Opens the image gallery.
- **Camera**: Opens the device camera.

```kotlin
// Setting an Alarm
findViewById<Button>(R.id.btnAlarm).setOnClickListener {

    Intent(AlarmClock.ACTION_SET_ALARM).apply {

        putExtra(AlarmClock.EXTRA_HOUR, 7)
        putExtra(AlarmClock.EXTRA_MINUTES, 30)
        putExtra(AlarmClock.EXTRA_MESSAGE, "Wake Up")

    }.also {
        startActivity(it)
    }
}
```

- **AlarmClock**: Uses extras like `EXTRA_HOUR` and `EXTRA_MINUTES` to configure the system alarm.

---

### 2. Explicit Intent

Explicit intents are used to start a specific component, such as an Activity, within the same application.

```kotlin
// Navigating to LoginActivity
findViewById<Button>(R.id.btnLogin).setOnClickListener {

    Intent(
        this@MainActivity,
        LoginActivity::class.java
    ).also {
        startActivity(it)
    }
}
```

- **Target Class**: Explicitly mentions `LoginActivity::class.java` as the destination.

---

## UI Details

### Main Activity (`activity_main.xml`)

The main screen uses a `ConstraintLayout` to organize various interactive elements:

- **Inputs**: `EditText` fields for Website URL and Phone Number.
- **Actions**: Buttons for Browse, Call, Call Log, Gallery, Camera, Alarm, and Login.
- **Layout**: Uses ConstraintLayout constraints to align labels, input fields, and buttons.

### Login Activity (`activity_login.xml`)

The Login Activity contains:

- **Logo**: University logo at the top using `ImageView`.
- **Form**: Email and Password input fields.
- **Login Button**: Allows the user to perform login.
- **Forgot Password**: Provides a password recovery option.

---

**Enrollment No:** 24012011175  
**Last Updated:** 2026-09-01
        startActivity(it)
    }
}
