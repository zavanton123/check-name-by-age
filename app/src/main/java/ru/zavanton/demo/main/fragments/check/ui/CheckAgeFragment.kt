package ru.zavanton.demo.main.fragments.check.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zavanton.demo.EMPTY
import ru.zavanton.demo.R
import ru.zavanton.demo.databinding.FragmentCheckAgeBinding
import ru.zavanton.demo.main.fragments.check.di.CheckAgeComponentManager
import javax.inject.Inject

class CheckAgeFragment : Fragment() {

    private lateinit var binding: FragmentCheckAgeBinding

    @Inject
    lateinit var viewModelFactory: CheckAgeViewModelFactory

    private val detailViewModel by viewModels<CheckAgeViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        CheckAgeComponentManager.getComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCheckAgeBinding.inflate(inflater, container, false)
        binding.detailViewModel = detailViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel.personUiModel.observe(viewLifecycleOwner) { personCheckUiModel ->
            binding.tvResult.text = resources.getString(
                R.string.name_with_age,
                binding.etName.text.toString(),
                personCheckUiModel.age.toString()
            )
            binding.etName.setText(EMPTY)
        }

        binding.tvDetail.setOnClickListener {
            detailViewModel.checkAge(binding.etName.text.toString().trim())
        }

        binding.etName.addTextChangedListener {
            val content = it ?: EMPTY
            binding.tvDetail.isEnabled = content.trim().isNotEmpty()
        }
    }
}
