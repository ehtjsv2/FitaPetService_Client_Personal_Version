package com.example.fitapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.fitapet.fragment.FriendFragment
import com.example.fitapet.fragment.HomeFragment
import com.example.fitapet.fragment.IngFragment
import com.example.fitapet.fragment.MypageFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.ing -> {
                    loadFragment(IngFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.friend -> {
                    loadFragment(FriendFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.mypage -> {
                    loadFragment(MypageFragment())
                    return@setOnNavigationItemReselectedListener
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

