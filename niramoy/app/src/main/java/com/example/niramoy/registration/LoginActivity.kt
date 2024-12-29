package com.example.niramoy.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.niramoy.R
import com.example.niramoy.admin.AdminPage

import com.example.niramoy.nurse.Nurse_homepage
import com.example.niramoy.user.User_Dashboard


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
                val role = authenticateUser(email, password)
                if (role != null) {
                    Toast.makeText(this, "Login Successful as $role", Toast.LENGTH_SHORT).show()
                    navigateToRoleBasedDashboard(role)
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

    private fun authenticateUser(email: String, password: String): String? {
        // Replace this with real authentication logic (e.g., API call, Firebase)
        // Example hardcoded users for demonstration
        return when {
            email == "admin@example.com" && password == "admin123" -> "admin"
            email == "nurse@example.com" && password == "nurse123" -> "nurse"
            email == "user@example.com" && password == "user123" -> "user"
            else -> null
        }
    }

    private fun navigateToRoleBasedDashboard(role: String) {
        when (role) {
            "admin" -> {
                val intent = Intent(this, AdminPage::class.java)
                startActivity(intent)
            }
            "nurse" -> {
                val intent = Intent(this, Nurse_homepage::class.java)
                startActivity(intent)
            }
            "user" -> {
                val intent = Intent(this, User_Dashboard::class.java)
                startActivity(intent)
            }
        }
        finish() // Close the login activity
    }
}
