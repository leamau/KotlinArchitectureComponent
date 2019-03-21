package com.example.architecturecomponent.data.data.remote


import com.google.gson.annotations.SerializedName

data class RecipesListResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<RecipeResponse>,

    @SerializedName("total_results")
    var totalResults: Int,

    @SerializedName("total_pages")
    var totalPages: Int
)