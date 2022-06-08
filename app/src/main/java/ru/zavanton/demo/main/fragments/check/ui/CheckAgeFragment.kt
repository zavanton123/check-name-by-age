package ru.zavanton.demo.main.fragments.check.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zavanton.demo.databinding.FragmentCheckAgeBinding

class CheckAgeFragment : Fragment() {

    private lateinit var binding: FragmentCheckAgeBinding

    private val detailViewModel by viewModels<CheckAgeViewModel>()

    companion object {
        private const val DETAIL_ID_ARG = "detailId"

        fun newFragment() = CheckAgeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckAgeBinding.inflate(inflater, container, false)
        binding.detailViewModel = detailViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDetail.setOnClickListener {
            detailViewModel.click()
        }
    }
}
