package ru.zavanton.demo.main.fragments.welcome.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.zavanton.demo.databinding.FragmentWelcomeBinding
import ru.zavanton.demo.main.fragments.welcome.di.WelcomeComponentManager

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private val viewModel by viewModels<WelcomeViewModel> {
        WelcomeComponentManager.getComponent().provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WelcomeComponentManager.getComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchLatestName()

        binding.tvDetail.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }
    }
}
