package space.rybakov.meringueimdb.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import space.rybakov.meringueimdb.data.api.ApiService
import space.rybakov.meringueimdb.data.entity.FilmEntity
import space.rybakov.meringueimdb.data.error.ApiError
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : FilmRepository {

    private val _data = MutableSharedFlow<List<Film>>(replay = 1)
    override val data: Flow<List<Film>>
        get() = _data

    override suspend fun search(title: String, page: Int) {
        val response = apiService.search(title, page, API_KEY)
        if (!response.isSuccessful) {
            throw ApiError(response.code(), response.message())
        }

        val body = response.body() ?: throw ApiError(response.code(), response.message())
        _data.tryEmit(body.Search.map(FilmEntity::toDto))
    }

    override suspend fun getByTitle(title: String) {
        val response = apiService.getByTitle(title, API_KEY)
        if (!response.isSuccessful) {
            throw ApiError(response.code(), response.message())
        }

        val body = response.body() ?: throw ApiError(response.code(), response.message())

        println(body)
    }

    override suspend fun getById(id: String) {
        val response = apiService.getById(id, API_KEY)
        if (!response.isSuccessful) {
            throw ApiError(response.code(), response.message())
        }

        val body = response.body() ?: throw ApiError(response.code(), response.message())
        println(body)
    }

    companion object {
        private val API_KEY = "80cdf7f7"
    }
}