package com.example.yokino.models

data class PopularMovies(
    val items: List<Item>,
    val total: Int,
    val totalPages: Int
)