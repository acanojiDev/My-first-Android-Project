package com.example.miprimeraapp

import android.app.Application

class TaskApplication:Application() { //hace que esto sea nuestra primera clase que se ejecute cuando nuestra app se inicie

    companion object{
        lateinit var  prefs:Preferences;
    }

    override fun onCreate() {
        prefs = Preferences(baseContext)//El contexto de toda la aplicación
        super.onCreate()
    }
}