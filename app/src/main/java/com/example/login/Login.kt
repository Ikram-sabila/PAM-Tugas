package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var userName: EditText
    private lateinit var nim: EditText
    private lateinit var radioButtonPria: RadioButton
    private lateinit var radioButtonWanita: RadioButton


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.button)
        userName = findViewById(R.id.editText_Username)
        nim = findViewById(R.id.editText_Nim)
        radioButtonPria = findViewById(R.id.radioButton)
        radioButtonWanita = findViewById(R.id.radioButton1)

        val options = arrayOf("Sarjana(S1)", "Magister(S2)", "Doktor(S3)")
        val spinner: Spinner = findViewById(R.id.spinner)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        loginButton.setOnClickListener {
            val username = userName.text.toString()
            val nim = nim.text.toString()
            val gender = if (radioButtonPria.isChecked) "Pria" else "Wanita"
            val selectedItem = spinner.selectedItem.toString()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("USERNAME", username)
                putExtra("NIM", nim)
                putExtra("GENDER", gender)
                putExtra("SELECTED_ITEM", selectedItem)
            }
            startActivity(intent)
            finish()
        }



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = options[position]
                
                Toast.makeText(applicationContext, "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
}
