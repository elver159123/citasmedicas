package com.sigfred.citasmedicas.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigfred.citasmedicas.Adapter.CategoryAdapter
import com.sigfred.citasmedicas.Adapter.TopDoctorAdapter
import com.sigfred.citasmedicas.ViewModel.MainViewModel
import com.sigfred.citasmedicas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { // Cambiado para heredar correctamente
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel // Usar ViewModel correctamente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java] // Inicialización correcta del ViewModel

        initCategory()
        initTopDoctors()
    }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctor.visibility = View.VISIBLE

            viewModel.doctors.observe(this@MainActivity) { doctorList ->
                doctorList?.let {
                    recyclerViewTopDoctor.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                    recyclerViewTopDoctor.adapter = TopDoctorAdapter(it)
                    progressBarTopDoctor.visibility = View.GONE
                }
            }

            viewModel.loadDoctors()

            doctorListTxt.setOnClickListener {
                startActivity(Intent(this@MainActivity, TopDoctorsActivity::class.java))
            }
        }
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE

        viewModel.category.observe(this@MainActivity) { categoryList ->
            categoryList?.let {
                binding.viewCategory.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.viewCategory.adapter = CategoryAdapter(it)
                binding.progressBarCategory.visibility = View.GONE
            }
        }

        viewModel.loadCategory()
    }
}
