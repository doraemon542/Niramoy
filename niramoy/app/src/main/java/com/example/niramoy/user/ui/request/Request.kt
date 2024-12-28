package com.example.niramoy.user.ui.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.niramoy.databinding.FragmentRequestBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Request : Fragment() {

    private var _binding: FragmentRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout using ViewBinding
        _binding = FragmentRequestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up button click listener
        binding.btnSaveRequest.setOnClickListener {
            saveRequestToFirebase()
        }

        return root
    }

    private fun saveRequestToFirebase() {
        // Get input from the EditText fields
        val title = binding.etRequestTitle.text.toString().trim()
        val description = binding.etRequestDescription.text.toString().trim()
        val fromTime = binding.etFromTime.text.toString().trim()
        val toTime = binding.etToTime.text.toString().trim()
        val numberOfDays = binding.etNumberOfDays.text.toString().trim()
        val salary = binding.etSalary.text.toString().trim()

        // Validate inputs
        if (title.isEmpty() || description.isEmpty() || fromTime.isEmpty() || toTime.isEmpty() || numberOfDays.isEmpty() || salary.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a request object or map to send to Firebase
        val requestData = mapOf(
            "title" to title,
            "description" to description,
            "fromTime" to fromTime,
            "toTime" to toTime,
            "numberOfDays" to numberOfDays,
            "salary" to salary
        )

        // Reference to Firebase Realtime Database
        val database = Firebase.database
        val requestsRef = database.getReference("requests")

        // Push the data to the database
        requestsRef.push().setValue(requestData)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Request saved successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { error ->
                Toast.makeText(requireContext(), "Failed to save request: ${error.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
