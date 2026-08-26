package com.example.a24012011175_mad_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        implicitintent()
        explicitintent()

    }
    fun implicitintent(){
        findViewById<Button>(R.id.btnBrowse).setOnClickListener { Intent(Intent.ACTION_VIEW, Uri.parse(findViewById<EditText>(R.id.edtWeb).text.toString())).also { startActivity(it) } }
        val number = findViewById<EditText>(R.id.edtPhone).text.toString()
        val callbutton = findViewById<Button>(R.id.btnCall)
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData("tel:$number".toUri())
        callbutton.setOnClickListener { startActivity(intent) }
    }

    fun explicitintent(){

    }
}