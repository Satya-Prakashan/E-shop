package com.example.eshop.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import java.io.Serializable


class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        var helper=DBHelper(applicationContext)
        var db=helper.readableDatabase

        signinBtn.setOnClickListener {
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name_key",etEmail.text.toString())
            editor.apply()
            editor.commit()

            var args= listOf<String>(etEmail.text.toString(),etPass.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM register WHERE email=? AND password=?",args)

            if(rs.moveToNext()){
                Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
                etPass.setText("")
            }
        }

        signupBtn.setOnClickListener{
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}