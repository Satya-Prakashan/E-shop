package com.example.eshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eshop.Activity.DetailProductActivity
import com.example.eshop.Models.fastFood
import com.example.eshop.Models.listen
import com.example.eshop.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycle_view.view.*


class ProductAdapter(var foodlist: ArrayList<fastFood>, val cellClickListener: CellClickListener) : RecyclerView.Adapter<ProductAdapter.ItemviewHolder>(){


    fun updateLamps(newfood: ArrayList<fastFood>) {
        foodlist.clear()
        foodlist.addAll(newfood)
        notifyDataSetChanged()
    }


    fun launchNextScreen(context: Context, ff: fastFood, position: Int): Intent {
        val intent = Intent(context, DetailProductActivity::class.java)
        intent.putExtra("fastFood", ff)
        intent.putExtra("position",position)

        return intent
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemviewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_recycle_view, parent, false)

        return ItemviewHolder(cellForRow).listen { pos, type ->
            val lamp:fastFood = foodlist.get(pos)
            parent.context.startActivity(launchNextScreen(parent.context, lamp,pos))
        }

    }


    override fun getItemCount() = foodlist.size


    override fun onBindViewHolder(holder: ItemviewHolder, position: Int) {
        holder.bind(foodlist[position])
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(position)
        }
    }



    class ItemviewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val preview = view.previewIcon
        private val title = view.title
        private val price = view.price


        fun bind(ff: fastFood) {
            Picasso.get().load(ff.image).into(preview)
            title.text = ff.title
            price.text = "$${ff.price}"

             }

        }
}
