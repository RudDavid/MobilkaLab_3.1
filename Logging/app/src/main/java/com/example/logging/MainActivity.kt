package com.example.logging

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.util.Log
import android.widget.EditText
import timber.log.Timber

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

        val button_Log = findViewById<Button>(R.id.button_log)
        val text = findViewById<EditText>(R.id.editTextText)
        val button_timber= findViewById<Button>(R.id.button_timber)

        button_Log.setOnClickListener {
            //Получаем текст для лога
            val log_text = text.text.toString()
            Log.v("Вы написали: ", log_text)
        }

        Timber.plant(Timber.DebugTree())

        button_timber.setOnClickListener {
            val inputText = text.text.toString()

            Timber.v(inputText)
        }
    }
}