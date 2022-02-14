package com.example.eshop.Activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eshop.R
import android.view.WindowManager

import android.os.Build
import android.view.Window
import android.widget.Button
import android.widget.Toast
import com.example.eshop.DBHelper
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var helper=DBHelper(applicationContext)
        var db=helper.readableDatabase

        signinBtn.setOnClickListener {

            var args= listOf<String>(etEmail.text.toString(),etPass.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM register WHERE email=? AND password=?",args)
            if(rs.moveToNext()){
                Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                etEmail.text.toString()==""
                etPass.text.toString()==""

            }


        }

        signupBtn.setOnClickListener{
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}