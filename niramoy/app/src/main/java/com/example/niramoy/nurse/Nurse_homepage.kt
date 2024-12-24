package com.example.niramoy.nurse

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.niramoy.R

import android.content.Intent
import androidx.activity.enableEdgeToEdge


import android.widget.ImageView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Nurse_homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nurse_homepage)

        val ivProfile = findViewById<ImageView>(R.id.ivProfile)




        // Sample hardcoded data
        val requestList = listOf(
            Request("John Doe", "Post-surgery care", "1 Month","From 7am to 7pm", "Dhaka, Bangladesh", "20000tk Monthly", R.drawable.pro),
            Request("Jane Smith", "Elderly care", "5 Month", "From 9am to 7pm","Chittagong, Bangladesh", "15000tk Monthly", R.drawable.profile),
            Request("Alice Brown", "Infant care", "3 Month", "From 7am to 7pm","Sylhet, Bangladesh", "25000tk Monthly", R.drawable.pro),
            Request("Janegadhama Smith", "Elderly care", "6 Month", "From 9am to 5pm","Khulna, Bangladesh", "15000tk Monthly", R.drawable.profile),
            Request("Johnsagolie Doe", "Post-surgery care", "3 Month", "From 9am to 7pm","Barishal, Bangladesh", "25000tk Monthly", R.drawable.pro),
            Request("Jane Gonje", "Elderly care", "7 Month", "From 9pm to 7am","Rajshahi, Bangladesh", "30000tk Monthly", R.drawable.profile)
        )



        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerRequests)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RequestAdapter(requestList)



    }
}