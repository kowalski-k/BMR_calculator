package com.example.caloriecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sexSpinner: Spinner
        sexSpinner = findViewById<Spinner>(R.id.sexspinner);

        var heightEditText: EditText
        heightEditText = findViewById(R.id.height_edit_text)

        var weightEditTextView: EditText
        weightEditTextView = findViewById(R.id.weight_edit_text)

        var ageEditText: EditText
        ageEditText = findViewById(R.id.age_edit_text)


        var option: String
        val options = arrayOf("Man", "Woman")


        sexSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options)
        sexSpinner.onItemSelectedListener = object : OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                option = options.get(position)
            }

        }
    }
}
