package com.example.bottomnavigationwithmeow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NotifFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notif, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NotifFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}