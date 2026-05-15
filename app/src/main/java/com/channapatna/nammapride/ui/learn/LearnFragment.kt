package com.channapatna.nammapride.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.channapatna.nammapride.data.AppData
import com.channapatna.nammapride.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupProcessTab()
        setupTabButtons()
        showTab("process")
    }

    private fun setupProcessTab() {
        val adapter = ProcessStepAdapter(AppData.processSteps)
        binding.rvProcess.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    private fun setupTabButtons() {
        binding.tabProcess.setOnClickListener { showTab("process") }
        binding.tabVideo.setOnClickListener { showTab("video") }
        binding.tabGi.setOnClickListener { showTab("gi") }
    }

    private fun showTab(tab: String) {
        // Reset all tabs
        listOf(binding.tabProcess, binding.tabVideo, binding.tabGi).forEach {
            it.isSelected = false
        }

        // Hide all containers
        binding.layoutProcess.visibility = View.GONE
        binding.layoutVideo.visibility = View.GONE
        binding.layoutGi.visibility = View.GONE

        when (tab) {
            "process" -> {
                binding.tabProcess.isSelected = true
                binding.layoutProcess.visibility = View.VISIBLE
            }
            "video" -> {
                binding.tabVideo.isSelected = true
                binding.layoutVideo.visibility = View.VISIBLE
            }
            "gi" -> {
                binding.tabGi.isSelected = true
                binding.layoutGi.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
