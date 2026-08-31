# Practical 3: Implicit and Explicit Intent

## Aim

Create an Android application which demonstrates implicit and explicit Intent.

---

## Application Demo

<table width="100%">
<tr>
<td width="50%" valign="top">

### 🎥 Demo

Add your GitHub screen recording link here.

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
findViewById<Button>(R.id.btn_Browse).setOnClickListener {
    val url = findViewById<EditText>(R.id.editTextText).text.toString()

    Intent(Intent.ACTION_VIEW, url.toUri()).also {
        startActivity(it)
    }
}

// Opening Dialer with a Number
findViewById<Button>(R.id.btn_Call).setOnClickListener {
    val number = findViewById<EditText>(R.id.editTextText2).text.toString()

    Intent(Intent.ACTION_DIAL).apply {
        data = "tel:$number".toUri()
    }.also {
        startActivity(it)
    }
}

// Setting an Alarm
findViewById<Button>(R.id.btn_Alarm).setOnClickListener {
    Intent(AlarmClock.ACTION_SET_ALARM).apply {
        putExtra(AlarmClock.EXTRA_HOUR, 7)
        putExtra(AlarmClock.EXTRA_MINUTES, 30)
        putExtra(AlarmClock.EXTRA_MESSAGE, "Wake Up")
    }.also {
        startActivity(it)
    }
}

// Navigating to LoginActivity
findViewById<Button>(R.id.btn_Login).setOnClickListener {
    Intent(this, LoginActivity::class.java).also {
        startActivity(it)
    }
}
