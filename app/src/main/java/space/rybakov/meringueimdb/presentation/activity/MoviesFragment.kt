package space.rybakov.meringueimdb.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.add
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import space.rybakov.meringueimdb.R
import space.rybakov.meringueimdb.databinding.FragmentMoviesBinding
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.presentation.adapter.FilmAdapter
import space.rybakov.meringueimdb.presentation.viewholder.OnInteractionListener
import space.rybakov.meringueimdb.presentation.viewmodel.FilmViewModel

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel: FilmViewModel by activityViewModels()

    private var _binding: FragmentMoviesBinding? = null
    private val binding: FragmentMoviesBinding
        get() = _binding ?: throw RuntimeException("FragmentFeedBinding == null!")

    private val adapter = FilmAdapter(object : OnInteractionListener {
        override fun onLike(post: Film) {
            findNavController().navigate(R.id.action_FilmFragment_to_DetailsFragment)

            TODO("Not yet implemented")
        }

        override fun onComment(post: Film) {
            TODO("Not yet implemented")
        }

        override fun onDetails(post: Film) {
            TODO("Not yet implemented")
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        binding.filmsList.adapter = adapter

        observeViewModel()

        return binding.root
    }

    private fun observeViewModel() {
        viewModel.data.observe(viewLifecycleOwner) { feedModel ->
            println(feedModel.films)
            adapter.submitList(feedModel.films)
        }

        // TODO: Добавить вывод об отсутствии фильмов из feedModel.empty
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.toolbar.buttonAction.setOnClickListener {
            //findNavController().navigate(R.id.action_FilmsFragment_to_SearchFragment)
            parentFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment, SearchFragment())
                .addToBackStack("Search")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}