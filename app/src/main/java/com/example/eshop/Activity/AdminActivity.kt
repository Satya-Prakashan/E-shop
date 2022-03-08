package com.example.eshop.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.eshop.DBHelper
import com.example.eshop.Fragments.Home
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var helper= DBHelper(applicationContext)
        var db=helper.readableDatabase

        preferences=getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)
        val email=preferences.getString("name_key","")
        var rs=db.rawQuery("SELECT phoneno FROM register WHERE email='$email'",null)
        rs.moveToNext()
        tvUserPhoneNumber.text = "+91 "+rs.getString(0)
        tvAdminName.text="$email"
        ibBackButton.setOnClickListener {
            intent =Intent(this,Home::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}
