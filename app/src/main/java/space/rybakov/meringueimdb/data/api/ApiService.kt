package space.rybakov.meringueimdb.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import space.rybakov.meringueimdb.data.entity.FilmEntity
import space.rybakov.meringueimdb.data.entity.Search

interface ApiService {

    @GET(".")
    suspend fun search(
        @Query("s") title: String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String
    ): Response<Search>

    @GET(".")
    suspend fun getByTitle(
        @Query("t") title: String,
        @Query("apikey") apikey: String
    ): Response<FilmEntity>

    @GET(".")
    suspend fun getById(
        @Query("i") id: String,
        @Query("apikey") apikey: String
    ): Response<FilmEntity>

}