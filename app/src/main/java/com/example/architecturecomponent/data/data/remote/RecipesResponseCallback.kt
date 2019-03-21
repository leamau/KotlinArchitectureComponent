package com.example.architecturecomponent.data.data.remote

interface RecipesResponseCallback {

    fun onSuccess()

    fun onError(throwable: Throwable)
}