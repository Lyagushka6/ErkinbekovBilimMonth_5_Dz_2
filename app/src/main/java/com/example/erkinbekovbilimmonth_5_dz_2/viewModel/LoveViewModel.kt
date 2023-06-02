package com.example.erkinbekovbilimmonth_5_dz_2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.erkinbekovbilimmonth_5_dz_2.repository.Repository
import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun liveLove(firstName: String, secondName: String): LiveData<LoveModel>{
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}