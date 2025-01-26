package com.example.sazonify_v2.data

class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: kotlin.Boolean? = null,
    val e: E? = null
)