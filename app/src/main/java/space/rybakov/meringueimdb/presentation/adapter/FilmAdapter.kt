package space.rybakov.meringueimdb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import space.rybakov.meringueimdb.databinding.CardFilmBinding
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.presentation.viewholder.FilmViewHolder
import space.rybakov.meringueimdb.presentation.viewholder.OnInteractionListener

class FilmAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Film, FilmViewHolder>(FilmDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = CardFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}