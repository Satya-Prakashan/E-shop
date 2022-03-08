package com.example.eshop.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eshop.Fragments.*
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var isOrderHasData: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setCurrentFragment(Home())
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(Home())
                R.id.orders->
                    if(isOrderHasData){
                        setCurrentFragment(Orders())
                    }else{
                        setCurrentFragment(EmptyOrderFragment())
                    }
                R.id.settings->setCurrentFragment(About())
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment)
            commit()
        }

    override fun onResume() {
        super.onResume()
    }

    private fun bottomNavigation(){

    }

}