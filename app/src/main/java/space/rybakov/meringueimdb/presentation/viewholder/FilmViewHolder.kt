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
    }

    private fun setContent(film: Film) {
        binding.apply {
            textViewTitle.text = film.title
            textViewYear.text = film.year
            textViewType.text = "Movie" // TODO: брать из фильма
            imageViewPoster.load(film.poster)
        }
    }

}