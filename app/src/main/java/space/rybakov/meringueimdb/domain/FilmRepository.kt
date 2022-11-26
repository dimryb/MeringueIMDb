package space.rybakov.meringueimdb.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    val data: Flow<List<FilmItem>>

    suspend fun getByTitle(title: String)
    suspend fun getById(id: Long)
    // suspend fun likeById(id: Long) TODO: разобраться как в Api лайки ставить
}