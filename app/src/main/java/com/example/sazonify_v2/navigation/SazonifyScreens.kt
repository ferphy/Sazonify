package com.example.sazonify_v2.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeScreenRoute{
}

@Serializable
data class DetailScreenRoute(
    val id: Int
)

@Serializable
data object NewTaskScreenRoute{
}

