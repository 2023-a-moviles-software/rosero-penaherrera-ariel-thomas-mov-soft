package com.example.deber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deber.adapter.KfcUsuarioAdapter

class recyclerView2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view2)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.kfcUsuario)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = KfcUsuarioAdapter(KfcUsuarioProveedor.kfcUsuariosLista)
    }

}