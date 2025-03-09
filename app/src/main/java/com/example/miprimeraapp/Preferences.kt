package com.example.miprimeraapp

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    companion object{ //Es la forma de acceder a esa informacion desde otras clases
        const val PREFS_NAME =  "myDatabase"
        const val TASKS = "taks_value"
    }

    private val prefs:SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun saveTask(tasks:List<String>){
        prefs.edit().putStringSet(TASKS, tasks.toSet()).apply()
    }

    fun getTasks():MutableList<String>{
        return prefs.getStringSet(TASKS, emptySet<String>())?.toMutableList() ?: mutableListOf()
    }
}