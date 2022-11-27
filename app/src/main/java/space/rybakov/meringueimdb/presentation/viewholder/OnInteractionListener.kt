package space.rybakov.meringueimdb.presentation.viewholder

import space.rybakov.meringueimdb.domain.Film

interface OnInteractionListener {
    fun onLike(post: Film)
    fun onComment(post: Film)
    fun onDetails(post: Film)
}