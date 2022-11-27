package space.rybakov.meringueimdb.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import space.rybakov.meringueimdb.databinding.FragmentMoviesBinding
import space.rybakov.meringueimdb.presentation.viewmodel.FilmViewModel

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel: FilmViewModel by activityViewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding: FragmentMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentFeedBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSearch.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            viewModel.search(title = "avatar", quantity = 2)
        }

        viewModel.data.observe(viewLifecycleOwner) { feedModel ->
            println(feedModel.films)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.search(title = "avatar", quantity = 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}