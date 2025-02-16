package com.sigfred.citasmedicas.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigfred.citasmedicas.Adapter.TopDoctorAdapter2
import com.sigfred.citasmedicas.ViewModel.MainViewModel
import com.sigfred.citasmedicas.databinding.ActivityTopDoctorsBinding

class TopDoctorsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopDoctorsBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java] // Usar ViewModelProvider

        initTopDoctors()
    }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctor.visibility = View.VISIBLE

            viewModel.doctors.observe(this@TopDoctorsActivity) { doctorsList ->
                doctorsList?.let {
                    viewTopDoctorList.layoutManager =
                        LinearLayoutManager(this@TopDoctorsActivity, LinearLayoutManager.VERTICAL, false)
                    viewTopDoctorList.adapter = TopDoctorAdapter2(it)
                    progressBarTopDoctor.visibility = View.GONE
                }
            }

            viewModel.loadDoctors()

            backBtn.setOnClickListener {
                finish()
            }
        }
    }
}
