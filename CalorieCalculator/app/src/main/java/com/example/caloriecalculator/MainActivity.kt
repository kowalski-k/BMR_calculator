package com.example.caloriecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sexSpinner: Spinner
        sexSpinner = findViewById<Spinner>(R.id.sexspinner);
    }
}
