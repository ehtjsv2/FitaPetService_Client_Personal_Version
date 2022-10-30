package com.example.fitapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.fitapet.fragment.FriendFragment
import com.example.fitapet.fragment.HomeFragment
import com.example.fitapet.fragment.IngFragment
import com.example.fitapet.fragment.MypageFragment
import com.example.fitapet.ui.animalReg.AnimalRegFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(AnimalRegFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@setOnItemReselectedListener
                }
                R.id.ing -> {
                    loadFragment(IngFragment())
                    return@setOnItemReselectedListener
                }
                R.id.friend -> {
                    loadFragment(FriendFragment())
                    return@setOnItemReselectedListener
                }
                R.id.mypage -> {
                    loadFragment(MypageFragment())
                    return@setOnItemReselectedListener
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

