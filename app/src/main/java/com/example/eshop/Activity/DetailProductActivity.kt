package com.example.eshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eshop.DBHelper
import com.example.eshop.Models.*
import com.example.eshop.R
import kotlinx.android.synthetic.main.activity_detail_product.*

class DetailProductActivity : AppCompatActivity() {
    var noOrder=1
    var allitemList: ArrayList<fastFood> = getAllLamps()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val db= DBHelper(this).writableDatabase


    val position=intent.getIntExtra("pos",0)


        var items: fastFood =allitemList[position]
        titleText.text=items.title
        productPrice.text="₹"+items.price
        previewIcon.setImageResource(items.image)
        descriptionText.text=items.description


        plusBtn.setOnClickListener {
            if(noOrder<25){
                noOrder++
            }
            numberOrderTxt.text=noOrder.toString()
        }

        minusBtn.setOnClickListener {
            if(noOrder>1){
                noOrder--
            }
            numberOrderTxt.text=noOrder.toString()
        }

        val newRecord= Orders(items.title,noOrder.toString(),items.price)
//        db?.execSQL(DBOrders.insert(db,newRecord).toString())

        btnPurchase.setOnClickListener {

            val i=Intent(this,EmptyCartActivity::class.java)
            i.putExtra("orders",noOrder)
            i.putExtra("price",items.price.toInt())
            startActivity(i)
        }
    }


}