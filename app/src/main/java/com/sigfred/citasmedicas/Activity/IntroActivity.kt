package com.sigfred.citasmedicas.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sigfred.citasmedicas.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startBtn.setOnClickListener {
                startActivity(Intent(this@IntroActivity, Login::class.java))
                finish()
            }
        }
    }
}
