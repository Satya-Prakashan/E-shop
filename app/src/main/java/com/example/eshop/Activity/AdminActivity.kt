package com.example.eshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eshop.Fragments.Home
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        ibBackButton.setOnClickListener {
            intent =Intent(this,Home::class.java)
            startActivity(intent)
        }
    }
}