package com.example.fitapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.fitapet.fragment.FriendFragment
import com.example.fitapet.fragment.HomeFragment
import com.example.fitapet.fragment.IngFragment
import com.example.fitapet.fragment.MypageFragment
import com.example.fitapet.ui.animalReg.AnimalRegFragment
import com.example.fitapet.ui.animalReg.AnimalRegFragment02
import com.example.fitapet.ui.reservation.Reservation01Fragment
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LifeCycleTest","onCreate")
        loadFragment(PetListRecyclerFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Log.d("clickTest","homeclick!")
                    loadFragment(HomeFragment())
                    return@setOnItemReselectedListener
                }
                R.id.ing -> {
                    Log.d("clickTest","inglick!")
                    loadFragment(PetListRecyclerFragment())
                    return@setOnItemReselectedListener
                }
                R.id.friend -> {
                    Log.d("clickTest","friendclick!")
                    loadFragment(FriendFragment())
                    return@setOnItemReselectedListener
                }
                R.id.mypage -> {
                    Log.d("clickTest","mypagelick!")
                    loadFragment(MypageFragment())
                    return@setOnItemReselectedListener
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

