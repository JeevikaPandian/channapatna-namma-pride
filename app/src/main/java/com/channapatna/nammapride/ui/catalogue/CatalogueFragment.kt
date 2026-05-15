package com.channapatna.nammapride.ui.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.channapatna.nammapride.data.AppData
import com.channapatna.nammapride.databinding.FragmentCatalogueBinding
import com.channapatna.nammapride.model.Toy

class CatalogueFragment : Fragment() {

    private var _binding: FragmentCatalogueBinding? = null
    private val binding get() = _binding!!

    private lateinit var toyAdapter: ToyGridAdapter
    private var currentCategory = "all"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toyAdapter = ToyGridAdapter(AppData.toys)
        binding.rvToys.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = toyAdapter
        }

        setupFilters()
        renderToys("all")
    }

    private fun setupFilters() {
        val filterBtns = mapOf(
            binding.filterAll to "all",
            binding.filterTops to "tops",
            binding.filterHorses to "horses",
            binding.filterDolls to "dolls",
            binding.filterAnimals to "animals",
            binding.filterPuzzles to "puzzles"
        )

        filterBtns.forEach { (btn, cat) ->
            btn.setOnClickListener {
                filterBtns.keys.forEach { b -> b.isSelected = false }
                btn.isSelected = true
                renderToys(cat)
            }
        }
        binding.filterAll.isSelected = true
    }

    private fun renderToys(category: String) {
        currentCategory = category
        val filtered: List<Toy> = if (category == "all") AppData.toys
        else AppData.toys.filter { it.category == category }
        toyAdapter.updateData(filtered)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
