package space.rybakov.meringueimdb.presentation.model

sealed interface FeedModelState {
    object Idle : FeedModelState
    object Loading : FeedModelState
    object Error : FeedModelState
}
