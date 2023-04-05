package com.example.appq

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appq.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://general.63-141-249-130.plesk.page/"
class MainActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar
    private lateinit var binding: ActivityMainBinding
   // var videoUrl:String? = null


    private lateinit var drawerToggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // videoUrl = intent.extras?.getString("videoUrl")
      //  Log.d("TAG", "onCreate: $videoUrl")
        toolbar = findViewById(R.id.mytoolbar)

        setSupportActionBar(toolbar)

        statuscolor()
        drawer()
        bottomNavigation()

        // APi DATA



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater:MenuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    fun statuscolor(){

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
           window.setBackgroundDrawableResource(R.drawable.background_action)

        }

    }

    fun drawer(){

       drawerToggle = ActionBarDrawerToggle(this,binding.drawer,R.string.Open,R.string.Close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.toggle)



      val headerview : View =   binding.navView.inflateHeaderView(R.layout.headerdrawer)
        val cancel : ConstraintLayout = headerview.findViewById(R.id.drawercancel)
        cancel.setOnClickListener {
            binding.drawer.close()   //68 ->0
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    fun bottomNavigation(){
        val navcontroller = this.findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = findViewById(R.id.bottomnavview)
        navView.itemIconTintList = null
        navView.setupWithNavController(navcontroller)
        }





}