package com.example.bottomnavigationwithmeow

import android.content.Intent
import android.icu.text.CaseMap
import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mountainArrayList = dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MountainAdapter(mountainArrayList)
    }

    private fun dataInitialize(): ArrayList<Mountain> {
        val mountainArrayList = arrayListOf<Mountain>()

        val image = arrayOf(
            R.drawable.arjuna,
            R.drawable.arogopuro,
            R.drawable.buthak,
            R.drawable.penanggungan,
            R.drawable.raung,
            R.drawable.sumeru
        )
        val title = arrayOf(
            getString(R.string.arjuna),
            getString(R.string.Argopuro),
            getString(R.string.buthak),
            getString(R.string.Penanggungan),
            getString(R.string.Raung),
            getString(R.string.Sumeru)
        )

        for (i in image.indices) {
            val mountain = Mountain(image[i], title[i])
            mountainArrayList.add(mountain)
        }

        return mountainArrayList
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}