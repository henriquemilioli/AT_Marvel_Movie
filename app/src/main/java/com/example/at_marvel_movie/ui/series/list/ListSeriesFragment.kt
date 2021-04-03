package com.example.at_marvel_movie.ui.series.list


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import com.example.at_marvel_movie.R


class ListSeriesFragment : Fragment() {



    private lateinit var viewModel: ListSeriesViewModel

    private lateinit var listViewSeries: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_series_fragment, container, false)

        listViewSeries = view.findViewById(R.id.listViewSeries)
        viewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)
        viewModel.series.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty())
                listViewSeries.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    it
                )
        })

        return view
    }




}