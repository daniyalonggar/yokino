package com.example.yokino.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.yokino.MAIN

import com.example.yokino.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var mainBinding : FragmentMainBinding ?= null
    private val binding get() = mainBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun init() {

        val viewModel= ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        try {
            viewModel.getMovies()
            viewModel.myMovies.observe(this, {list ->
                adapter.setList(list.body()!!.items)
            })
        }catch (e: Exception){
Toast.makeText(MAIN, e.message, Toast.LENGTH_SHORT).show()
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainBinding = null
    }

}