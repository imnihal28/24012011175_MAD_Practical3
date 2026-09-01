package com.example.a24012011175_mad_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        implicitintent()
        explicitintent()
    }


    fun implicitintent() {

        // Web Browse
        findViewById<Button>(R.id.btnBrowse).setOnClickListener {

            val url =
                findViewById<EditText>(R.id.edtWeb)
                    .text
                    .toString()

            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            ).also {
                startActivity(it)
            }
        }


        // Phone Call
        findViewById<Button>(R.id.btnCall).setOnClickListener {

            val number =
                findViewById<EditText>(R.id.edtPhone)
                    .text
                    .toString()

            Intent(
                Intent.ACTION_DIAL,
                "tel:$number".toUri()
            ).also {
                startActivity(it)
            }
        }


        // Call Log
        findViewById<Button>(R.id.btnCallLog).setOnClickListener {

            Intent(
                Intent.ACTION_VIEW,
                CallLog.Calls.CONTENT_URI
            ).also {
                startActivity(it)
            }
        }


        // Gallery
        findViewById<Button>(R.id.btnGallery).setOnClickListener {

            Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            ).also {
                startActivity(it)
            }
        }


        // Camera
        findViewById<Button>(R.id.btnCamera).setOnClickListener {

            Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
            ).also {
                startActivity(it)
            }
        }


        // Alarm
        findViewById<Button>(R.id.btnAlarm).setOnClickListener {

            Intent(
                AlarmClock.ACTION_SHOW_ALARMS
            ).also {
                startActivity(it)
            }
        }
    }


    fun explicitintent() {

        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {

            Intent(this@MainActivity,
                LoginActivity::class.java).apply { startActivity(this) }
        }
    }
}