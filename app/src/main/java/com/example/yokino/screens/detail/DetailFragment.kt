package com.example.yokino.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.yokino.R
import com.example.yokino.databinding.FragmentDetailBinding
import com.example.yokino.databinding.FragmentMainBinding
import com.example.yokino.screens.favorite.FavoriteFragmentViewModel
import com.example.yokino.screens.main.MainAdapter

class DetailFragment : Fragment() {
    private var mainBinding : FragmentDetailBinding?= null
    private val binding get() = mainBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      mainBinding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        val viewModel= ViewModelProvider(this).get(DetailViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainBinding = null
    }
}