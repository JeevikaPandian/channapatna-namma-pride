package com.channapatna.nammapride.ui.workshops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.channapatna.nammapride.databinding.ItemWorkshopBinding
import com.channapatna.nammapride.model.Workshop

class WorkshopAdapter(
    private val workshops: List<Workshop>,
    private val onClickItem: (Workshop) -> Unit
) : RecyclerView.Adapter<WorkshopAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemWorkshopBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWorkshopBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val w = workshops[position]
        with(holder.binding) {
            tvWorkshopEmoji.text = w.emoji
            tvWorkshopName.text = w.name
            tvWorkshopAddress.text = w.address
            tvWorkshopHours.text = "⏰ ${w.hours}"
            root.setOnClickListener { onClickItem(w) }
        }
    }

    override fun getItemCount() = workshops.size
}
