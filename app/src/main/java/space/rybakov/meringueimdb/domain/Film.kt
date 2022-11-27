package space.rybakov.meringueimdb.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val id: String,
    val title: String,
    val year: String,
    val poster: String,
    val type: String,

    val url: String,
): Parcelable
