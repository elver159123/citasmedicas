package com.sigfred.citasmedicas.Activity

import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.sigfred.citasmedicas.Domain.CitaModel
import com.sigfred.citasmedicas.databinding.ActivityAgendarCitaBinding

class AgendarCita : BaseActivity2() {

    private lateinit var binding: ActivityAgendarCitaBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendarCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Acción del botón Volver
        binding.btnBack.setOnClickListener {
            onBackPressed() // Esta función regresa a la actividad anterior
        }

        // Al hacer clic en el botón para guardar la cita
        binding.btnSaveCita.setOnClickListener {
            val doctorName = intent.getStringExtra("doctorName") ?: "Desconocido" // Si es necesario
            val patientName = binding.etPatientName.text.toString()
            val appointmentDate = binding.etAppointmentDate.text.toString()
            val appointmentTime = binding.etAppointmentTime.text.toString()

            if (patientName.isNotEmpty() && appointmentDate.isNotEmpty() && appointmentTime.isNotEmpty()) {
                saveCitaToFirestore(doctorName, patientName, appointmentDate, appointmentTime)
            } else {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveCitaToFirestore(
        doctorName: String,
        patientName: String,
        appointmentDate: String,
        appointmentTime: String
    ) {
        val cita = CitaModel(
            doctorName = doctorName,
            patientName = patientName,
            appointmentDate = appointmentDate,
            appointmentTime = appointmentTime
        )

        // Crear una referencia a la colección "citas"
        db.collection("citas")
            .add(cita) // Agrega el objeto de la cita a Firestore
            .addOnSuccessListener {
                Toast.makeText(this, "Cita agendada con éxito", Toast.LENGTH_SHORT).show()
                finish() // Finaliza la actividad o puedes navegar a otra pantalla
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al agendar la cita: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
