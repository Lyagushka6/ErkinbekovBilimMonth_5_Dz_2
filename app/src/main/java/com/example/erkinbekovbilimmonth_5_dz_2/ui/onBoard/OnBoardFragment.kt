package com.example.erkinbekovbilimmonth_5_dz_2.ui.onBoard

import com.example.erkinbekovbilimmonth_5_dz_2.ui.onBoard.adapter.OnBoardAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.data.local.Pref
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardFragment: Fragment() {

    lateinit var binding: FragmentOnBoardBinding
    private val adapter = OnBoardAdapter(this::onStartClick)
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicatorDots.attachTo(binding.viewPager)
    }

    private fun onStartClick(){
        pref.saveSeen()
        findNavController().navigate(R.id.loveCalculatorFragment)
    }
}