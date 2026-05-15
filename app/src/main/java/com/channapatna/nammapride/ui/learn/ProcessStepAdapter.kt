package com.channapatna.nammapride.ui.learn

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.channapatna.nammapride.databinding.ItemProcessStepBinding
import com.channapatna.nammapride.model.ProcessStep

class ProcessStepAdapter(private val steps: List<ProcessStep>) :
    RecyclerView.Adapter<ProcessStepAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProcessStepBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProcessStepBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val step = steps[position]
        with(holder.binding) {
            tvStepNumber.text = step.stepNumber.toString()
            tvStepTitle.text = step.title
            tvStepDesc.text = step.description

            try {
                val drawable = GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    intArrayOf(Color.parseColor(step.colorStart), Color.parseColor(step.colorEnd))
                )
                drawable.cornerRadius = 50f
                tvStepNumber.background = drawable
            } catch (_: Exception) {}
        }
    }

    override fun getItemCount() = steps.size
}
