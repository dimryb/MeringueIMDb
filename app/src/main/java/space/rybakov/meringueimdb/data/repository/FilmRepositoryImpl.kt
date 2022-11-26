package space.rybakov.meringueimdb.data.repository

import kotlinx.coroutines.flow.Flow
import space.rybakov.meringueimdb.domain.FilmItem
import space.rybakov.meringueimdb.domain.FilmRepository

class FilmRepositoryImpl : FilmRepository {
    override val data: Flow<List<FilmItem>>
        get() = TODO("Not yet implemented")

    override suspend fun getByTitle(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Long) {
        TODO("Not yet implemented")
    }
}