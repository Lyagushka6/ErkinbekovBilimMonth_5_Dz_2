package com.example.erkinbekovbilimmonth_5_dz_2.ui.history.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.ItemHistoryBinding
import com.example.erkinbekovbilimmonth_5_dz_2.model.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>(){

    private val data = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(loveModel: List<LoveModel>){
        data.addAll(loveModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding): ViewHolder(binding.root){
        fun bind(loveModel: LoveModel) {
            binding.apply {
                tvFirstName.text = loveModel.firstName
                tvSecondname.text = loveModel.secondName
                tvPercentage.text = loveModel.percentage
            }
        }

    }
}