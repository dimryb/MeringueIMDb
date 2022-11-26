package space.rybakov.meringueimdb.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.rybakov.meringueimdb.data.repository.FilmRepositoryImpl
import space.rybakov.meringueimdb.domain.FilmRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}