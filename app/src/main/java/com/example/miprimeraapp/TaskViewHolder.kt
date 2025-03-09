package com.example.miprimeraapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) { //Esto lo que haces es la variable view de la clase View que hereda de RecyclerView.ViewHolder necesita como parametro esa vista
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val ivTaskDone: ImageView = view.findViewById(R.id.ivTaskDone)

    fun render(task:String, onItemDone: (Int) -> Unit){
        tvTask.text = task
        ivTaskDone.setOnClickListener{onItemDone(adapterPosition)} //return the actual position
    }
}