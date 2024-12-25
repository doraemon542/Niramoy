package com.example.niramoy.nurse

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.niramoy.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var ivProfilePicture: ImageView
    private lateinit var ivEditIcon: ImageView
    private val PICK_IMAGE_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)



        val llProfile: LinearLayout = findViewById(R.id.llRequests)

        // Set an OnClickListener
        llProfile.setOnClickListener {
            // Navigate to the ProfileActivity
            val intent = Intent(this, Nurse_homepage::class.java)
            startActivity(intent)
        }


        ivProfilePicture = findViewById(R.id.ivProfilePicture)
        ivEditIcon = findViewById(R.id.ivEditIcon)

        ivEditIcon.setOnClickListener {
            openImagePicker()
        }

        val requestList = listOf(
            PatientDetails(
                details = "Post-Surgery Care Required",
                date = "2024-11-01 to 2024-12-30",
                location = "20006",
                review = "The nurse was excellent and very caring."
            ),
            PatientDetails(
                details = "Elderly Care Needed",
                date = "2024-11-01 to 2024-12-30",
                location = "20006",
                review = "Great experience with the caregiver."
            ),
            PatientDetails(
                details = "Elderly Care Needed",
                date = "2025-11-01 to 2025-12-30",
                location = "30008",
                review = "Great experience with the caregiver."
            ),
            PatientDetails(
                details = "Child Care Required",
                date = "2024-11-01 to 2024-12-30",
                location = "50010",
                review = "The service was satisfactory and professional."
            )


        )


        val recyclerView: RecyclerView = findViewById(R.id.rvPatientDetails)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PatientDetailsAdapter(requestList)
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            ivProfilePicture.setImageURI(imageUri)
        }
    }
}