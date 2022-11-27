package space.rybakov.meringueimdb.presentation.viewholder

import space.rybakov.meringueimdb.domain.Film

interface OnInteractionListener {
    fun onLike(film: Film)
    fun onComment(film: Film)
    fun onDetails(film: Film)
}