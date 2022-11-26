package space.rybakov.meringueimdb.data.api

import retrofit2.http.POST

interface ApiService {

    @POST("t={title}")
    suspend fun getByTitle(title: String)

    @POST("i={id}")
    suspend fun getById(id: String)

}