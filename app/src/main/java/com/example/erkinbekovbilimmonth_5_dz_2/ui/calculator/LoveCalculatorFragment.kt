package com.example.erkinbekovbilimmonth_5_dz_2.ui.calculator

import android.net.DnsResolver.Callback
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.FragmentLoveCalculatorBinding
import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel
import com.example.erkinbekovbilimmonth_5_dz_2.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Response

class LoveCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculatorBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            btnCalculate.setOnClickListener {
                RetrofitService().api.getPercentage(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        findNavController().navigate(
                            R.id.loveScoreFragment, bundleOf(
                                KEY_FOR_FNAME to response.body()?.firstName,
                                KEY_FOR_SNAME to response.body()?.secondName,
                                KEY_FOR_PERCE to response.body()?.percentage,
                            )
                        )
                        firstNameEd.text?.clear()
                        secondNameEd.text?.clear()
                    }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("iuuuuu", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
    companion object {
        const val KEY_FOR_FNAME = "firstName"
        const val KEY_FOR_SNAME = "secondName"
        const val KEY_FOR_PERCE = "123%"
    }
}