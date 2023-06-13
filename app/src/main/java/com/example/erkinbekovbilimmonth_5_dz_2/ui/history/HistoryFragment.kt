package com.example.erkinbekovbilimmonth_5_dz_2.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilimmonth_5_dz_2.App
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.data.local.AppDatabase
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.FragmentHistoryBinding
import com.example.erkinbekovbilimmonth_5_dz_2.ui.history.adapter.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class HistoryFragment : Fragment() {

    private val db = App.appDatabase
    lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation()
        setData()
    }

    private fun navigation() {
        binding.apply {
            btnHome.setOnClickListener {
                findNavController().navigate(R.id.loveCalculatorFragment)
            }
        }
    }

    private fun setData() {
        val data = db.getDao().getAll()
        adapter.addList(data)
        binding.recyclerView.adapter = adapter
    }
}