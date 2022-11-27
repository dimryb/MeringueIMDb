package space.rybakov.meringueimdb.data.entity

import space.rybakov.meringueimdb.domain.Film

data class FilmEntity(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Poster: String,
    val Type: String,
) {
    fun toDto(): Film = Film(
        id = imdbID,
        title = Title,
        year = Year,
        poster = Poster,
        type = Type,
    )

    companion object {
        fun fromDto(film: Film): FilmEntity =
            with(film) { return FilmEntity(title, year, id, poster, type) }
    }
}
