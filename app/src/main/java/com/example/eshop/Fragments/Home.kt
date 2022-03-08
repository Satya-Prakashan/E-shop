package com.example.eshop.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eshop.Activity.*
import com.example.eshop.Adapter.CellClickListener
import com.example.eshop.Adapter.ProductAdapter
import com.example.eshop.Models.fastFood
import com.example.eshop.Models.getAllLamps
import com.example.eshop.Models.setItemss
import com.example.eshop.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment(),CellClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        view.rvHome.layoutManager=LinearLayoutManager(activity)
       // view.rvHome.adapter=ProductAdapter()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addAlltoList()

        ivToolbarProfile.setOnClickListener {
            val intent=Intent(getActivity(),AdminActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        tvToolbarLocation.setOnClickListener {
            val intent=Intent(getActivity(),LocationActivity::class.java)
            getActivity()?.startActivity(intent)
        }


        additemstoList()

    }

    private fun additemstoList() {
        val allitemList: ArrayList<fastFood> = getAllLamps()

        rvHome.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        rvHome.adapter = ProductAdapter(foodlist = allitemList,this)
    }

    private fun addAlltoList() {
        val listItem=ArrayList<fastFood>()
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Burger","Yummy!",R.drawable.burger,"69"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))
        listItem.add(fastFood("Pizza","Yummy!",R.drawable.pizza1,"99"))

        setItemss(listItem)
    }

    override fun onCellClickListener(position: Int) {
        activity?.let {
            val i=Intent(it,DetailProductActivity::class.java)
            i.putExtra("pos",position)
            it.startActivity(i)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Home().apply {
                arguments = Bundle().apply {
                }
            }

    }
}