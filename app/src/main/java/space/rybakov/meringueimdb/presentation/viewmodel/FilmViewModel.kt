package space.rybakov.meringueimdb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import space.rybakov.meringueimdb.domain.FilmRepository
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository,
): ViewModel() {



}