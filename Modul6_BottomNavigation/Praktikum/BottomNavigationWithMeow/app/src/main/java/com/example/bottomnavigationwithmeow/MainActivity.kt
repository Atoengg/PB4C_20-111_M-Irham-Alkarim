package com.example.bottomnavigationwithmeow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation : MeowBottomNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)

        bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.baseline_home_24))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.baseline_view_list_24))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.baseline_notifications_24))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.baseline_person_24))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    replaceFragment(ListFragment.newInstance())

                }
                2 -> {
                    replaceFragment(NotifFragment.newInstance())

                }
                3 -> {
                    replaceFragment(ProfileFragment.newInstance())

                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}