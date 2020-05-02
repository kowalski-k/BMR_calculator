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
        sexSpinner = findViewById<Spinner>(R.id.sex_spinner)
        sexSpinner.prompt

        val activitySpinner: Spinner
        activitySpinner = findViewById(R.id.activity_spinner)

        var option_sex: String
        var option_activity: String


        var heightEditText: EditText
        heightEditText = findViewById(R.id.height_edit_text)

        var weightEditTextView: EditText
        weightEditTextView = findViewById(R.id.weight_edit_text)

        var ageEditText: EditText
        ageEditText = findViewById(R.id.age_edit_text)


        ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sexSpinner.adapter = adapter}

        sexSpinner.onItemSelectedListener = object : OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (parent != null) {
                    option_sex = parent.getItemAtPosition(position) as String
                }
            }
        }

        ArrayAdapter.createFromResource(this, R.array.activity_array, android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                activitySpinner.adapter = adapter}

        activitySpinner.onItemSelectedListener = object : OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (parent != null) {
                    option_activity = parent.getItemAtPosition(position) as String

                }
            }
        }


    }
}
