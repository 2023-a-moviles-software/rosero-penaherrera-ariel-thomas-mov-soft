package com.example.gmail

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.databinding.ActivityPagPrincipalBinding
import com.example.gmail.ui.home.CorreoProvider
import com.example.gmail.ui.home.adapter.CorreoAdapter

class Pag_principal : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPagPrincipalBinding
    //private lateinit var binding2: ActivityPagPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPagPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        setSupportActionBar(binding.appBarPagPrincipal.toolbar)

        binding.appBarPagPrincipal.fab.setOnClickListener { view ->
            Snackbar.make(view, "Enviar correos próximamente", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_pag_principal)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_primary, R.id.nav_promotions, R.id.nav_social
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.pag_principal, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_pag_principal)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_correos)
        recyclerView.layoutManager = manager
        recyclerView.adapter = CorreoAdapter(CorreoProvider.correosList)
        recyclerView.addItemDecoration(decoration)
    }
}