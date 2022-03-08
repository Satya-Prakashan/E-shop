package com.example.eshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eshop.Fragments.Home
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_empty_cart.*

class EmptyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_cart)

    val price=intent.getIntExtra("price",0)
        val orders=intent.getIntExtra("orders",0)
        update(price,orders)

        backBtn.setOnClickListener {
            val i =Intent(this,Home::class.java)
            startActivity(i)
        }
    }

    fun update(price:Int,orders:Int){
        totalFeeTxt.text= orders.toString()
        deliveryTxt.text="₹"+"10";
        val total=price*orders-10
        taxTxt.text="₹"+((total*0.02*100)/100).toString();
        totalTxt.text="₹"+(total-((total*0.02*100)/100)).toString()
    }
}