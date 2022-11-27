package space.rybakov.meringueimdb.presentation.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import space.rybakov.meringueimdb.databinding.FragmentDetailsBinding
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.presentation.view.load
import space.rybakov.meringueimdb.presentation.viewmodel.FilmViewModel

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()

    private val viewModel: FilmViewModel by activityViewModels()

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailsBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent(args.film)
        setupClickListener(args.film)
    }

    private fun setContent(film: Film){
        binding.apply {
            textViewTitleDetail.text = film.title
            textViewYearDetail.text = film.year
            textViewTypeDetail.text = film.type
            imageViewPosterDetail.load(film.poster)
        }
    }

    private fun setupClickListener(film: Film){
        binding.apply {
            toolbar.buttonAction.setOnClickListener{
                findNavController().navigateUp()
            }
            buttonImdb.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(film.url)))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}