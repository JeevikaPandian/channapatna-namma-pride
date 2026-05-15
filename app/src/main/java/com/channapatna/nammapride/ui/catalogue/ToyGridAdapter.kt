package com.channapatna.nammapride.ui.catalogue

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.channapatna.nammapride.databinding.ItemToyCardBinding
import com.channapatna.nammapride.model.Toy

class ToyGridAdapter(private var toys: List<Toy>) :
    RecyclerView.Adapter<ToyGridAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemToyCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemToyCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toy = toys[position]
        with(holder.binding) {
            tvToyEmoji.text = toy.emoji
            tvToyName.text = toy.name
            tvToyArtisan.text = "by ${toy.artisan}"
            tvToyPrice.text = toy.price
            try {
                layoutToyThumb.setBackgroundColor(Color.parseColor(toy.bgColor))
            } catch (_: Exception) {}
            tvGiBadge.visibility = if (toy.isGICertified) View.VISIBLE else View.GONE
        }
    }

    override fun getItemCount() = toys.size

    fun updateData(newToys: List<Toy>) {
        toys = newToys
        notifyDataSetChanged()
    }
}
