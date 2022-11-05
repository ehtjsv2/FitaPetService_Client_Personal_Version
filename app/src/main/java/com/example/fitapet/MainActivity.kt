package com.example.fitapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.fitapet.navfragment.FriendFragment
import com.example.fitapet.navfragment.HomeFragment
import com.example.fitapet.navfragment.IngFragment
import com.example.fitapet.navfragment.MypageFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.ing -> {
                    loadFragment(IngFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.friend -> {
                    loadFragment(FriendFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.mypage -> {
                    loadFragment(MypageFragment())
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

