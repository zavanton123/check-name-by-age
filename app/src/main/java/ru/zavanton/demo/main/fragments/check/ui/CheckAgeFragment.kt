package ru.zavanton.demo.main.fragments.check.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zavanton.demo.databinding.FragmentCheckAgeBinding
import ru.zavanton.demo.main.fragments.check.di.CheckAgeComponentManager

class CheckAgeFragment : Fragment() {

    private lateinit var binding: FragmentCheckAgeBinding

    private val detailViewModel by viewModels<CheckAgeViewModel> {
        CheckAgeComponentManager.getComponent().viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        CheckAgeComponentManager.getComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
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
