package space.rybakov.meringueimdb.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    val data: Flow<List<Film>>

    suspend fun search(title: String, page: Int)
    suspend fun getByTitle(title: String)
    suspend fun getById(id: String)
    suspend fun likeById(id: String, liked: Boolean)
    suspend fun commentById(id: String, comment: String)
}