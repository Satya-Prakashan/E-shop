package com.example.eshop.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eshop.Activity.AdminActivity
import com.example.eshop.R
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivToolbarProfile.setOnClickListener {
            val intent=Intent(getActivity(),AdminActivity::class.java)
            getActivity()?.startActivity(intent)
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