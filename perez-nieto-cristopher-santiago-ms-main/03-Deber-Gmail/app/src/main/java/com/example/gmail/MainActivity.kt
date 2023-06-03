package com.example.gmail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.adapter1.PerfilAdapter
import com.example.gmail.databinding.ActivityMainBinding
import com.example.gmail.ui.home.CorreoProvider
import com.example.gmail.ui.home.adapter.CorreoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val btnIrPantallaPrincipal: Button = findViewById(R.id.btn_ir_pag_principal)
        btnIrPantallaPrincipal
            .setOnClickListener{
                irActividad(Pag_principal::class.java)
            }*/

        initRecyclerView()
    }

    fun irActividad(
        clase: Class<*>
    ) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        //val recyclerView = findViewById<RecyclerView>(R.id.recycler_perfiles)
        binding.recyclerPerfiles.layoutManager = manager
        binding.recyclerPerfiles.adapter =
            PerfilAdapter(PerfilProvider.perfilesList) {perfil ->
                irActividad(
                    Pag_principal::class.java
                )
        }
        binding.recyclerPerfiles.addItemDecoration(decoration)
    }

    /*fun onItemSelected(perfil: Perfil){

    }*/
}