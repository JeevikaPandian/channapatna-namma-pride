package com.channapatna.nammapride.ui.workshops

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.channapatna.nammapride.data.AppData
import com.channapatna.nammapride.databinding.FragmentWorkshopsBinding

class WorkshopsFragment : Fragment() {

    private var _binding: FragmentWorkshopsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkshopsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WorkshopAdapter(AppData.workshops) { workshop ->
            // Open in Google Maps
            val uri = Uri.parse("geo:${workshop.latitude},${workshop.longitude}?q=${Uri.encode(workshop.name)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.rvWorkshops.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
