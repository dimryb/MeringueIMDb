package space.rybakov.meringueimdb.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import space.rybakov.meringueimdb.domain.Film

class FilmDiffCallback : DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}