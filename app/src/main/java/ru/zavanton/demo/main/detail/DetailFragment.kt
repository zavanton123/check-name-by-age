package ru.zavanton.demo.main.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zavanton.demo.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel by viewModels<DetailViewModel>()

    companion object {
        private const val DETAIL_ID_ARG = "detailId"

        fun newFragment() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(DETAIL_ID_ARG) ?: "not available"
        Log.d("zavanton", "zavanton - id: $id")

        binding.tvDetail.setOnClickListener {
            viewModel.click()
        }
    }
}
