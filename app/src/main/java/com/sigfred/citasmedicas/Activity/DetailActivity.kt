package com.sigfred.citasmedicas.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sigfred.citasmedicas.Domain.DoctorsModel
import com.sigfred.citasmedicas.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity2() {
    private lateinit var binding: ActivityDetailBinding
    private var item: DoctorsModel? = null // Evita crashes por `null`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")

        item?.let { doctor -> // Evita `NullPointerException`
            binding.apply {
                titleTxt.text = doctor.Name
                specialTxt.text = doctor.Special
                patiensTxt.text = doctor.Patiens
                bioTxt.text = doctor.Biography
                addressTxt.text = doctor.Address
                experienceTxt.text = "${doctor.Exprience} Years"
                ratingTxt.text = doctor.Rating.toString() // ¿En lugar de `Picture`?

                backBtn.setOnClickListener {
                    finish()
                }


                websiteBtn.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(doctor.Site))
                    startActivity(i)
                }

                messageBtn.setOnClickListener {
                    val uri = Uri.parse("smsto:${doctor.Mobile}")
                    val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
                        putExtra("sms_body", "the SMS text")
                    }
                    startActivity(intent)
                }

                callBtn.setOnClickListener {
                    val uri = "tel:${doctor.Mobile.trim()}"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse(uri))
                    startActivity(intent)
                }

                directionBtn.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(doctor.Location))
                    startActivity(intent)
                }

                shareBtn.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, doctor.Name)
                        putExtra(Intent.EXTRA_TEXT, "${doctor.Name} ${doctor.Address} ${doctor.Mobile}")
                    }
                    startActivity(Intent.createChooser(intent, "Choose one"))
                }

                Glide.with(this@DetailActivity)
                    .load(doctor.Picture)
                    .into(img)
            }
        } ?: run {
            finish() // Cierra la actividad si el objeto es `null`
        }
    }
}
