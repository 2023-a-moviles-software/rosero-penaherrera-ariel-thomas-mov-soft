package com.example.a04_examen_crud

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cancion::class], version = 1)
abstract class CancionDatabase : RoomDatabase() {
    abstract fun cancionDao(): CancionDao

    companion object {
        private var INSTANCE: CancionDatabase? = null

        fun getDatabase(context: Context): CancionDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CancionDatabase::class.java, "cancion_database")
                    .build()
            }
            return INSTANCE as CancionDatabase
        }
    }
}
