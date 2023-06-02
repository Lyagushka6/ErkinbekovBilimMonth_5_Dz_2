package com.example.erkinbekovbilimmonth_5_dz_2.ui.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.data.local.Pref
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.FragmentLoveCalculatorBinding
import com.example.erkinbekovbilimmonth_5_dz_2.viewModel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoveCalculatorFragment  : Fragment() {

    private lateinit var binding: FragmentLoveCalculatorBinding
    private val viewModel : LoveViewModel by viewModels()
    @Inject
    lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardSection()
        initListener()
    }

    private fun onBoardSection() {
        if (!pref.isUserSeen())
        findNavController().navigate(R.id.onBoardFragment)
    }

    private fun initListener() {
        binding.apply {
            btnCalculate.setOnClickListener {
                viewModel.liveLove(firstNameEd.text.toString(), secondNameEd.text.toString())
                    .observe(viewLifecycleOwner,Observer {
                        findNavController().navigate(
                            R.id.loveScoreFragment,
                            bundleOf(
                                KEY_FOR_FNAME to it.firstName,
                                KEY_FOR_SNAME to it.secondName,
                                KEY_FOR_PERCE to it.percentage,
                                KEY_FOR_RESULT to it.result
                            )
                        )
                    })
                firstNameEd.text?.clear()
                secondNameEd.text?.clear()
            }
        }
    }
    companion object {
        const val KEY_FOR_FNAME = "firstName"
        const val KEY_FOR_SNAME = "secondName"
        const val KEY_FOR_PERCE = "123%"
        const val KEY_FOR_RESULT = "result"
    }
}