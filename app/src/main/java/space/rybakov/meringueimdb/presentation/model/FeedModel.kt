package space.rybakov.meringueimdb.presentation.model

import space.rybakov.meringueimdb.domain.Film

data class FeedModel(
    val films: List<Film> = emptyList(),
    val empty: Boolean = false,
)
