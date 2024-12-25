package com.example.niramoy.nurse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.niramoy.R


data class PatientDetails(
    val details: String,

    val date: String,
    val location: String,

    val review: String
)

class PatientDetailsAdapter(private val requestList: List<PatientDetails>) :
    RecyclerView.Adapter<PatientDetailsAdapter.RequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.des_review, parent, false)
        return RequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {



        holder.setData(requestList[position])
    }

    override fun getItemCount(): Int = requestList.size


    class RequestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvPatientCondition: TextView = view.findViewById(R.id.tvJobTitle)
        private val tvPatientLocation: TextView = view.findViewById(R.id.tvServiceCode)
        private val tvWorkDuration: TextView = view.findViewById(R.id.tvWorkDuration)
        private val tvPatientReview: TextView = view.findViewById(R.id.tvPatientReview)


        fun setData(request: PatientDetails) {
            tvPatientCondition.text = "Role: ${request.details}"
            tvPatientLocation.text = "Service Code No: ${request.location}"
            tvWorkDuration.text = "Work Duration: ${request.date}"
            tvPatientReview.text = "Review: ${request.review}"

        }
    }


}



