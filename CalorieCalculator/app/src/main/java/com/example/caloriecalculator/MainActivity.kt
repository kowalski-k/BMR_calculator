package com.example.caloriecalculator

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var calculateButton: Button
    private lateinit var option_gender: String
    private lateinit var option_activity: String
    private lateinit var heightEditText: EditText
    private lateinit var weightEditTextView: EditText
    private lateinit var ageEditText: EditText
    private var BMR = 0.0
    private var CPM = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val genderSpinner: Spinner
        genderSpinner = findViewById<Spinner>(R.id.gender_spinner)
        genderSpinner.prompt

        val activitySpinner: Spinner
        activitySpinner = findViewById(R.id.activity_spinner)



        heightEditText = findViewById(R.id.height_edit_text)

        weightEditTextView = findViewById(R.id.weight_edit_text)

        ageEditText = findViewById(R.id.age_edit_text)

        calculateButton = findViewById(R.id.calculate_button)



        ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                genderSpinner.adapter = adapter}

        genderSpinner.onItemSelectedListener = object : OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (parent != null) {
                    option_gender = parent.getItemAtPosition(position) as String
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

        fun calculateBMR(): Double {
            if(option_gender == "Man"){
                BMR = 66 + (13.7 * weightEditTextView.text.toString().toDouble()) + (5 * heightEditText.text.toString().toDouble()) - (6.76 * ageEditText.text.toString().toDouble())
            }
            else{
                BMR = 655 + (9.6 * weightEditTextView.text.toString().toDouble()) + (1.8 * heightEditText.text.toString().toDouble()) - (4.7 * ageEditText.text.toString().toDouble())
            }
            return BMR
        }
        fun calculateCPM(): Int {
            if(option_activity == "Sedetary: no exercise"){
                CPM = (BMR * 1.2).toInt()
            }
            else if(option_activity == "Light: exercise 2-3 times/week"){
                CPM = (BMR * 1.35).toInt()
            }
            else if(option_activity == "Moderate: exercise 4-5 times/week"){
                CPM = (BMR * 1.55).toInt()
            }
            else if(option_activity == "Active: daily exercise or intense exercise 3-4 times/week"){
                CPM = (BMR * 1.75).toInt()
            }
            else if(option_activity == "Very active: intense exercise 6-7 times/week") {
                CPM = (BMR * 1.95).toInt()
            }
            else{
                CPM = (BMR * 2.2).toInt()
            }
            return CPM
        }

        fun result() {
            calculateBMR()
            calculateCPM()
            Toast.makeText(this, String.format(getResources().getString(R.string.resultCMP), CPM), Toast.LENGTH_LONG).show()
        }
        calculateButton.setOnClickListener { result() }
        }

    }

