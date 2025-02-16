package com.sigfred.citasmedicas.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sigfred.citasmedicas.Domain.CitaModel
import com.sigfred.citasmedicas.databinding.ListItemCitaBinding

class CitaAdapter : ListAdapter<CitaModel, CitaAdapter.CitaViewHolder>(CitaDiffCallback()) {

    // Se llama cuando un nuevo ViewHolder necesita ser creado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val binding = ListItemCitaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CitaViewHolder(binding)
    }

    // Se llama para vincular los datos del modelo con el ViewHolder
    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = getItem(position)
        holder.bind(cita)
    }

    // ViewHolder que mantiene las vistas de cada ítem
    class CitaViewHolder(private val binding: ListItemCitaBinding) : RecyclerView.ViewHolder(binding.root) {

        // Método que vincula los datos de la cita con las vistas
        fun bind(cita: CitaModel) {
            binding.apply {
                // Aquí asignamos los valores de la cita al diseño
                textViewDoctorName.text = cita.doctorName
                textViewSpecialty.text = cita.specialty
                textViewAppointmentTime.text = cita.appointmentTime
            }
        }
    }

    // Callback de DiffUtil para mejorar el rendimiento del RecyclerView (optimiza las actualizaciones de la lista)
    class CitaDiffCallback : DiffUtil.ItemCallback<CitaModel>() {
        override fun areItemsTheSame(oldItem: CitaModel, newItem: CitaModel): Boolean {
            // Aquí asumimos que el campo 'id' de CitaModel es único
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CitaModel, newItem: CitaModel): Boolean {
            // Compara los contenidos de los dos elementos
            return oldItem == newItem
        }
    }
}
