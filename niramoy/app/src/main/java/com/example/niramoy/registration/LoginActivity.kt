package com.example.niramoy.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingformobile.registrationuser.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerNowText = findViewById<TextView>(R.id.tvRegisterNow)
        val forgotPasswordText = findViewById<TextView>(R.id.tvForgotPassword)

        // Login Button Click
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                if (isValidCredentials(email, password)) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    // Navigate to Home Screen or Dashboard

                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // "Register Now" Click
        registerNowText.setOnClickListener {
            // Navigate to Registration Screen
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        // Forgot Password
        forgotPasswordText.setOnClickListener {
            Toast.makeText(this, "Redirecting to Forgot Password Screen", Toast.LENGTH_SHORT).show()
            // Handle forgot password action here
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        // Implement actual authentication logic here
        // For example, using Firebase Authentication or an API call
        return authenticateUser(email, password)
    }

    private fun authenticateUser(email: String, password: String): Boolean {
        // Placeholder for actual authentication logic
        // Return true if authentication is successful, false otherwise
        return false
    }
}