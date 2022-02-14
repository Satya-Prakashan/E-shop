package com.example.eshop.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.eshop.Fragments.*
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var isOrderHasData: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation()

    }

    override fun onResume() {
        super.onResume()
    }

    private fun bottomNavigation(){
        addFragment(Home.newInstance())
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_baseline_home_24))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_search_black_24dp))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_baseline_shopping_cart))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_user))

        bottomNavigation.setOnClickMenuListener {
            var temp:Fragment?=null
            when(it.id){
                0 -> {
                    temp=Home()                }
                1 -> {
                    replaceFragment(Search.newInstance())
                }
                2 -> {
                    if (isOrderHasData){
                        replaceFragment(Orders.newInstance())
                    }else{
                        replaceFragment(EmptyOrderFragment.newInstance())
                    }

                }
                3 -> {
                    replaceFragment(About.newInstance())
                }
                else -> {
                    replaceFragment(Home.newInstance())
                }
            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}