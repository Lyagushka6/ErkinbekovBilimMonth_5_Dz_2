package com.example.erkinbekovbilimmonth_5_dz_2.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.erkinbekovbilimmonth_5_dz_2.databinding.ItemOnboardBinding
import com.example.erkinbekovbilimmonth_5_dz_2.model.OnBoard

class OnBoardAdapter(private val onClick:() -> Unit): RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {


    private val data = arrayListOf(
        OnBoard(
            "https://img.freepik.com/free-vector/flat-valentine-s-day-illustration_23-2149221108.jpg",
            "Have a good time",
            "You should take the time to help those who need you"),
        OnBoard(
            "https://img.freepik.com/free-vector/flat-propose-day-illustration_23-2150078717.jpg",
            "Cherishing love",
            "It is now longer possible for you to cherish lov"),
        OnBoard(
            "https://media.istockphoto.com/id/1076600992/vector/saint-valentines-day-young-female-character-holding-a-red-heart-relationships-love-romance.jpg?s=612x612&w=0&k=20&c=j6Gh86hmHHfptKgyr3B-Gx8LTRxu14H7IzUiUhQkvis=",
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
                imgLove.load(onBoard.image)
                btnStart.isVisible = adapterPosition == 2
                btnStart.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}