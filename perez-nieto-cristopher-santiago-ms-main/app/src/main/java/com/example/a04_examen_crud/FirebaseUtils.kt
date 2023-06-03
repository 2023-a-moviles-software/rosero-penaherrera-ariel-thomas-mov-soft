package com.example.a04_examen_crud

import com.google.firebase.database.FirebaseDatabase

object FirebaseUtils {
    private var database: FirebaseDatabase? = null

    fun getDatabase(): FirebaseDatabase {
        if (database == null) {
            database = FirebaseDatabase.getInstance()
            database?.setPersistenceEnabled(true)
        }
        return database!!
    }
}