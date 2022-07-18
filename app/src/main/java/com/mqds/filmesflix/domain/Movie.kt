package com.mqds.filmesflix.domain

data class Movie(
    val id: Int,
    val title: String,
    val description: String?,
    val image: String,
    val lauchDate: String?
)
