package com.example.architecturecomponent.data.data.remote

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

        @SerializedName("id")
        val id: Int,

        @SerializedName("title")
        val title: String,

        @SerializedName("overview")
        val image: String,

        @SerializedName("release_date")
        val readyInMinutes: String

)