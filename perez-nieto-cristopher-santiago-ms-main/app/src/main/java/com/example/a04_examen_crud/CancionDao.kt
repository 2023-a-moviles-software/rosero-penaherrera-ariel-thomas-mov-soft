package com.example.a04_examen_crud

import androidx.room.*

@Dao
interface CancionDao {
    @Insert
    fun insert(cancion: Cancion)

    @Query("SELECT * FROM canciones")
    fun obtener_canciones(): List<Cancion>

    @Query("SELECT * FROM canciones WHERE id = :id")
    fun obtener_cancion_por_id(id: Int): Cancion

    @Update
    fun update(cancion: Cancion)

    @Delete
    fun delete(cancion: Cancion)
}
