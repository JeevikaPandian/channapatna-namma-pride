package com.channapatna.nammapride.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.channapatna.nammapride.R
import com.channapatna.nammapride.data.AppData
import com.channapatna.nammapride.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupArtisanCarousel()
        setupQuickActions()
    }

    private fun setupArtisanCarousel() {
        val adapter = ArtisanCardAdapter(AppData.artisans)
        binding.rvArtisans.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvArtisans.adapter = adapter
    }

    private fun setupQuickActions() {
        binding.cardScanToyId.setOnClickListener {
            findNavController().navigate(R.id.verifyFragment)
        }
        binding.cardAiAssistant.setOnClickListener {
            findNavController().navigate(R.id.aiFragment)
        }
        binding.cardWorkshops.setOnClickListener {
            findNavController().navigate(R.id.workshopsFragment)
        }
        binding.cardHowItsMade.setOnClickListener {
            findNavController().navigate(R.id.learnFragment)
        }
        binding.btnVerifyNow.setOnClickListener {
            findNavController().navigate(R.id.verifyFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
