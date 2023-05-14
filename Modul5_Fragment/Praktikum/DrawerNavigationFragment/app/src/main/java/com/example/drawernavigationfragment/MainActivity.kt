package com.example.drawernavigationfragment


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.navView)
        navigationView.setNavigationItemSelectedListener(this)

        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentHome()).commit()
            navigationView.setCheckedItem(R.id.navHome)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navHome -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentHome()).commit()
            R.id.navShare -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentShare()).commit()
            R.id.navSetting -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentSetting()).commit()
            R.id.navInfo -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentAbout()).commit()
            R.id.navLogout -> Toast.makeText(this, "Logout Bro", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

}