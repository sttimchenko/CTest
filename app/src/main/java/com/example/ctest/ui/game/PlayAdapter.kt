package com.example.ctest.ui.game

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.ctest.data.GameUnit
import com.example.ctest.databinding.ArmyItemBinding
import android.view.LayoutInflater



/**
 * Created by ss on 17.12.16.
 */
class PlayAdapter(var items: List<GameUnit>) : RecyclerView.Adapter<PlayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArmyItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        if (item.life > 0) holder.binding.unit = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding : ArmyItemBinding

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
}