package com.example.niramoy.nurse



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.niramoy.R


data class Request(
    val name: String,
    val details: String,
    val duration: String,
    val period: String,
    val location: String,
    val salary: String,
    val profileImageResId: Int
)


class RequestAdapter(private val requestList: List<Request>) :
    RecyclerView.Adapter<RequestAdapter.RequestViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_request, parent, false)
        return RequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {



        holder.setData(requestList[position])
    }

    override fun getItemCount(): Int = requestList.size


    class RequestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvPatientName: TextView = view.findViewById(R.id.tvPatientName)
        private val tvRequestDetails: TextView = view.findViewById(R.id.tvRequestDetails)
        private val tvRequestDate: TextView = view.findViewById(R.id.tvRequestDate)
        private val tvTimePeriod: TextView = view.findViewById(R.id.tvTimePeriod)
        private val tvLocation: TextView = view.findViewById(R.id.tvLocation)
        private val tvSalary: TextView = view.findViewById(R.id.tvSalary)
        private val ivProfilePicture: ImageView = view.findViewById(R.id.ivProfilePicture)

        fun setData(request: Request) {
            tvPatientName.text = "Patient Name: ${request.name}"
            tvRequestDetails.text = "Care Needed: ${request.details}"
            tvRequestDate.text = "Duration: ${request.duration}"
            tvTimePeriod.text = "Time Period: ${request.period}"
            tvLocation.text = "Location: ${request.location}"
            tvSalary.text = "Salary: ${request.salary}"
            ivProfilePicture.setImageResource(request.profileImageResId)
        }
    }
}



