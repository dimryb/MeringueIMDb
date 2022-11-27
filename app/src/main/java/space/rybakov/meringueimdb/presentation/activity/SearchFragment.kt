package space.rybakov.meringueimdb.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import space.rybakov.meringueimdb.databinding.FragmentSearchBinding
import space.rybakov.meringueimdb.presentation.viewmodel.FilmViewModel
import java.lang.NumberFormatException

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: FilmViewModel by activityViewModels()

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentSearchBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        with(binding) {
            buttonApply.setOnClickListener {

                val title = editTextTitle.text.toString()
                if (title.isBlank()){
                    editTextTitle.requestFocus()
                    return@setOnClickListener
                }

                try {
                    val quantity = editTextQuantity.text.toString().toInt()
                    if ((quantity <= 0)||(quantity > 100)){
                        editTextQuantity.text.clear()
                        editTextQuantity.requestFocus()
                        return@setOnClickListener
                    }
                    viewModel.search(
                        title = title,
                        quantity = quantity
                    )
                    parentFragmentManager.popBackStack()
                }catch (e: NumberFormatException){
                    editTextQuantity.text.clear()
                    editTextQuantity.requestFocus()
                    return@setOnClickListener
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}