package com.example.erkinbekovbilimmonth_5_dz_2.ui.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.FragmentLoveScoreBinding
import com.example.erkinbekovbilimmonth_5_dz_2.ui.calculator.LoveCalculatorFragment

class LoveScoreFragment : Fragment() {

    private lateinit var binding: FragmentLoveScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoveScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnTryAgain()
        loveScore()
    }

    private fun loveScore() {
        arguments?.apply {
            val firstName = getString(LoveCalculatorFragment.KEY_FOR_FNAME)
            val secondName = getString(LoveCalculatorFragment.KEY_FOR_SNAME)
            val score = getString(LoveCalculatorFragment.KEY_FOR_PERCE)

            binding.apply {
                tvFirstName.text  = firstName
                tvSecondName.text = secondName
                tvScore.text = score
            }
        }
    }

    private fun btnTryAgain() {
            binding.apply {
                btnTryAgain.setOnClickListener{
                    findNavController().navigateUp()
            }
        }
    }
}