package space.rybakov.meringueimdb.data.repository

import kotlinx.coroutines.flow.Flow
import space.rybakov.meringueimdb.data.api.ApiService
import space.rybakov.meringueimdb.domain.FilmItem
import space.rybakov.meringueimdb.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): FilmRepository {
    override val data: Flow<List<FilmItem>>
        get() = TODO("Not yet implemented")

    override suspend fun getByTitle(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: String) {
        TODO("Not yet implemented")
    }
}