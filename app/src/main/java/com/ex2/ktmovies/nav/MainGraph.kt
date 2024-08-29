package com.ex2.ktmovies.nav

import kotlinx.serialization.Serializable

@Serializable
object HomeDestination

@Serializable
object SearchDestination

@Serializable
data class DetailsDestination(
    val id: String
)