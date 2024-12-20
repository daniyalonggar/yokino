package com.example.yokino.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.yokino.R
import com.example.yokino.databinding.FragmentFavoriteBinding
import com.example.yokino.databinding.FragmentMainBinding
import com.example.yokino.screens.main.MainAdapter
import com.example.yokino.screens.main.MainFragmentViewModel


class FavoriteFragment : Fragment() {
    private var mainBinding : FragmentFavoriteBinding?= null
    private val binding get() = mainBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      mainBinding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        val viewModel= ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainBinding = null
    }
}