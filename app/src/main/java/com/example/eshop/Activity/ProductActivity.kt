package com.example.eshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eshop.Adapter.ProductAdapter
import com.example.eshop.Models.fastFood
import com.example.eshop.Models.getAllLamps
import com.example.eshop.R

import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val allitemList: ArrayList<fastFood> = getAllLamps()

        productRecyclerView.layoutManager = GridLayoutManager(this, 2)
      //  productRecyclerView.adapter = ProductAdapter(foodlist = allitemList,this)



    }
}