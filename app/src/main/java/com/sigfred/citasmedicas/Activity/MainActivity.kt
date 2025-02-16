package com.sigfred.citasmedicas.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigfred.citasmedicas.Adapter.CategoryAdapter
import com.sigfred.citasmedicas.Adapter.TopDoctorAdapter
import com.sigfred.citasmedicas.ViewModel.MainViewModel
import com.sigfred.citasmedicas.databinding.ActivityMainBinding

class MainActivity : BaseActivity2() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initTopDoctors()

    }

    private fun initTopDoctors() {
        binding.apply{
            progressBarTopDoctor.visibility=View.VISIBLE
            viewModel.doctors.observe(this@MainActivity, Observer{
                recyclerViewTopDoctor.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewTopDoctor.adapter= TopDoctorAdapter(it)
                progressBarTopDoctor.visibility=View.GONE
            })
            viewModel.loadDoctors()
        }
    }

    private fun initCategory() {
     binding.progressBarCategory.visibility= View.VISIBLE
        viewModel.category.observe(this, Observer {
            binding.viewCategory.layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
            binding.viewCategory.adapter=CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE
        })
        viewModel.loadCategory()
    }
}