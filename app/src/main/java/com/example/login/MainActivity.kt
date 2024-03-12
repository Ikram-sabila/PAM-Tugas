package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var namautamaTextView: TextView
    private lateinit var usernameTextView: TextView
    private lateinit var nimTextView: TextView
    private lateinit var genderTextView: TextView
    private lateinit var spinnerTextView: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameTextView = findViewById(R.id.Text_Username)
        nimTextView = findViewById(R.id.Text_Nim)
        genderTextView = findViewById(R.id.Text_Gender)
        namautamaTextView = findViewById(R.id.text_namautama)
        spinnerTextView = findViewById(R.id.Text_Strata)


        val username = intent.getStringExtra("USERNAME")
        val nim = intent.getStringExtra("NIM")
        val gender = intent.getStringExtra("GENDER")
        val namautama = intent.getStringExtra("USERNAME")
        val spinnerValue = intent.getStringExtra("SELECTED_ITEM")


        usernameTextView.text = "Nama\t: $username"
        nimTextView.text = "NIM\t: $nim"
        genderTextView.text = "Gender\t: $gender"
        namautamaTextView.text = "$namautama"
        spinnerTextView.text = "Strata\t: $spinnerValue"
    }
}