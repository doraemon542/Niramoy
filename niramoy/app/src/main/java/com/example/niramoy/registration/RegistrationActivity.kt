package com.example.niramoy.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.codingformobile.registrationuser.R
import com.example.niramoy.R

class RegistrationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextNationalIdPassport = findViewById<EditText>(R.id.editTextNationalIdPassport)
        val checkBoxAgree = findViewById<CheckBox>(R.id.checkBoxAgree)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonnurse = findViewById<Button>(R.id.buttonnurse)
        val buttonlogin = findViewById<Button>(R.id.buttonlogin)
        buttonnurse.setOnClickListener {
            val intent = Intent(this, NurseRegistrationActivity::class.java)
            startActivity(intent)
        }
        buttonlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val nationalIdPassport = editTextNationalIdPassport.text.toString().trim()
            val isAgree = checkBoxAgree.isChecked

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || nationalIdPassport.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else if (!isAgree) {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                // You can add further registration logic here (e.g., save to database, authenticate, etc.)
                Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}