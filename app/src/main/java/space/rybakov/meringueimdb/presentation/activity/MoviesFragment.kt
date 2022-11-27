package space.rybakov.meringueimdb.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
        override fun onLike(film: Film) {
            viewModel.like(film.id, film.liked)
        }

        override fun onComment(film: Film, comment: String) {
            viewModel.comments(film.id, comment)
        }

        override fun onDetails(film: Film) {
            findNavController().navigate(
                MoviesFragmentDirections.actionFilmFragmentToDetailsFragment(film)
            )
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
            adapter.submitList(feedModel.films)
        }

        // TODO: Добавить вывод об отсутствии фильмов из feedModel.empty
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.buttonAction.setOnClickListener {
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