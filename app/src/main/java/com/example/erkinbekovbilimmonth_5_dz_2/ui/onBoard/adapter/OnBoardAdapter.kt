package com.example.erkinbekovbilimmonth_5_dz_2.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.erkinbekovbilimmonth_5_dz_2.R
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.ItemOnboardBinding
import com.example.erkinbekovbilimmonth_5_dz_2.model.OnBoard

class OnBoardAdapter(private val onClick:() -> Unit): Adapter<OnBoardAdapter.OnBoardViewHolder>() {


    private val data = arrayListOf(
        OnBoard(
            R.raw.heart_love,
            "Have a good time",
            "You should take the time to help those who need you"),
        OnBoard(
            R.raw.heart_balloons,
            "Cherishing love",
            "It is now longer possible for you to cherish lov"),
        OnBoard(
            R.raw.cupid_love,
            "Have a breakup?",
            "We have made the correction for you don't worry Maybe someone is waiting for you?")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(ItemOnboardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.apply {
                tvLove.text = onBoard.title
                tvLoveInfo.text = onBoard.description
                lottieAnim.setAnimation(onBoard.lottieAnimation)
                btnStart.isVisible = adapterPosition == 2
                btnStart.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}