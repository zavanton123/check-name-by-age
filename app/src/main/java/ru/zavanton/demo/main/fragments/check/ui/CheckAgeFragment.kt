package ru.zavanton.demo.main.fragments.check.ui

import android.os.Bundle
import android.util.Log
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

        detailViewModel.ageLiveData.observe(viewLifecycleOwner) { age ->
            Log.d("zavanton", "zavanton - ui age: $age")
            binding.tvResult.text = resources.getString(
                R.string.name_with_age,
                binding.etName.text.toString(),
                age.toString()
            )
            binding.etName.setText("")
        }

        binding.tvDetail.setOnClickListener {
            detailViewModel.checkAge(binding.etName.text.toString())
        }

        binding.etName.addTextChangedListener {
            Log.d("zavanton", "zavanton - listener")
            val content = it ?: EMPTY
            binding.tvDetail.isEnabled = content.isNotEmpty()
        }
    }
}
