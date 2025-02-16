package com.sigfred.citasmedicas.Domain

data class CitaModel(
    val id: String = "",               // ID único de la cita
    val doctorName: String = "",       // Nombre del doctor
    val specialty: String = "",        // Especialidad del doctor
    val patientName: String = "",      // Nombre del paciente
    val appointmentDate: String = "",  // Fecha de la cita
    val appointmentTime: String = "",  // Hora de la cita
    val status: String = "Pendiente"   // Estado de la cita (por defecto "Pendiente")
)

