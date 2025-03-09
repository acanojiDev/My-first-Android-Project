package com.example.miprimeraapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraapp.TaskApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddTask:Button
    private lateinit var etTask:EditText
    private lateinit var rvTasks:RecyclerView

    private lateinit var adapter: TaskAdapter

    private var tasks =  mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initUi()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUi(){
        initView()
        initListeners()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        tasks = prefs.getTasks()
        rvTasks.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter(tasks) { deleteTask(it) }
        rvTasks.adapter = adapter
    }

    private fun deleteTask(position:Int){
        tasks.removeAt(position)
        adapter.notifyItemRemoved(position)
        prefs.saveTask(tasks)
    }

    private fun initListeners() {
        btnAddTask.setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
        val newTask = etTask.text.toString()
        if (newTask.isNotEmpty()) {
            adapter.addTask(newTask)
            etTask.setText("")
            prefs.saveTask(tasks)
        }
    }


    private fun initView(){
        btnAddTask = findViewById(R.id.btnAddTask)
        etTask = findViewById(R.id.etTask)
        rvTasks = findViewById(R.id.rvTasks)
    }
}