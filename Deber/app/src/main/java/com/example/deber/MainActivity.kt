package com.example.deber

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deber.adapter.KfcAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val menu = bottomNavigation.menu
        val userItem = menu.findItem(R.id.usuario)
        userItem.setOnMenuItemClickListener {
            val intent = Intent(this, recyclerView2::class.java)
            startActivity(intent)
            true
        }

    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerkfc)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = KfcAdapter(KfcProveedor.kfcLista1)
    }

}