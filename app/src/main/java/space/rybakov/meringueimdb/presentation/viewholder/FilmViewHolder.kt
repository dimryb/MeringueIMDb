package space.rybakov.meringueimdb.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import space.rybakov.meringueimdb.databinding.CardFilmBinding
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.presentation.view.load

class FilmViewHolder(
    private val binding: CardFilmBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(film: Film) {
        setContent(film)
        setupClickListeners(film)
    }

    private fun setContent(film: Film) {
        binding.apply {
            textViewTitle.text = film.title
            textViewYear.text = film.year
            textViewType.text = film.type
            imageViewPoster.load(film.poster)
            buttonLike.isSelected = film.liked
        }
    }

    private fun setupClickListeners(film: Film) {
        binding.apply {
            buttonComment.setOnClickListener { onInteractionListener.onComment(film) }
            layoutFilm.setOnClickListener { onInteractionListener.onDetails(film) }
            imageViewPoster.setOnClickListener { onInteractionListener.onDetails(film) }

            buttonLike.setOnClickListener {
                it.isSelected = !it.isSelected
                onInteractionListener.onLike(film.copy(liked = it.isSelected))
            }
        }
    }

}