package space.rybakov.meringueimdb.presentation.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import space.rybakov.meringueimdb.domain.Film
import space.rybakov.meringueimdb.domain.FilmRepository
import space.rybakov.meringueimdb.presentation.model.FeedModel
import space.rybakov.meringueimdb.presentation.model.FeedModelState
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    val data: LiveData<FeedModel> = repository.data.map { films ->
        FeedModel(films, films.isEmpty())
    }.asLiveData(Dispatchers.Default)

    private val _state = MutableLiveData<FeedModelState>()
    val state: LiveData<FeedModelState>
        get() = _state

    fun search (title: String, quantity: Int){
        viewModelScope.launch {
            try {
                repository.search(title, page = quantity)
                _state.value = FeedModelState.Idle
            } catch (e: Exception){
                _state.value = FeedModelState.Error
            }
        }
    }

    fun like (id: String, liked: Boolean){
        viewModelScope.launch {
            try {
                repository.likeById(id, liked)
                _state.value = FeedModelState.Idle
            } catch (e: Exception){
                _state.value = FeedModelState.Error
            }
        }
    }

    fun comments (id: String, comment: String){
        viewModelScope.launch {
            try {
                repository.commentById(id, comment)
                _state.value = FeedModelState.Idle
            } catch (e: Exception){
                _state.value = FeedModelState.Error
            }
        }
    }

}