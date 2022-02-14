package com.example.eshop.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eshop.R

class EmptyOrderFragment : Fragment() {


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
        return inflater.inflate(R.layout.fragment_empty_order, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            EmptyOrderFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}