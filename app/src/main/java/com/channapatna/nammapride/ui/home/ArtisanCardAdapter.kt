package com.channapatna.nammapride.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.channapatna.nammapride.databinding.ItemArtisanCardBinding
import com.channapatna.nammapride.model.Artisan

class ArtisanCardAdapter(private val artisans: List<Artisan>) :
    RecyclerView.Adapter<ArtisanCardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemArtisanCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArtisanCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artisan = artisans[position]
        with(holder.binding) {
            tvArtisanEmoji.text = artisan.emoji
            tvArtisanName.text = artisan.name
            tvArtisanSpecialty.text = artisan.specialty
            tvArtisanRating.text = "⭐ ${artisan.rating}"
        }
    }

    override fun getItemCount() = artisans.size
}
