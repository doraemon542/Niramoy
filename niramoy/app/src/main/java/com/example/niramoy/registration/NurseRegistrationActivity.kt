package com.example.niramoy.registration

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingformobile.registrationuser.R

class NurseRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurse_registration)

        val btnRegister: Button = findViewById(R.id.btnRegister)
        val etName: EditText = findViewById(R.id.etName)
        val etNID: EditText = findViewById(R.id.etNID)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etRegCertNo: EditText = findViewById(R.id.etRegCertNo)
        val etSpecialField: EditText = findViewById(R.id.etSpecialField)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val cbTerms: CheckBox = findViewById(R.id.cbTerms)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val nid = etNID.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val regCertNo = etRegCertNo.text.toString().trim()
            val specialField = etSpecialField.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val termsAccepted = cbTerms.isChecked

            if (name.isEmpty() || nid.isEmpty() || email.isEmpty() || regCertNo.isEmpty() || specialField.isEmpty() || password.isEmpty()) {
                showToast("Please fill in all mandatory fields.")
            } else if (!termsAccepted) {
                showToast("Please accept the terms and conditions.")
            } else {
                showToast("Registration Successful!")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}