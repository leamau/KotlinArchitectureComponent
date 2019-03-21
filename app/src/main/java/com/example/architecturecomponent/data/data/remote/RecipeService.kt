package com.example.architecturecomponent.data.data.remote


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes/")
    fun getRecipes(@Query("language") language: String = "fr-FR",
                          @Query("page") page: Int = 1
    ): Observable<RecipesListResponse>

    @GET("recipes/search?query=burger")
    fun getRecipe(@Path("recipe") id: Int): Observable<RecipeResponse>

    companion object {

        fun create(): RecipeService {

            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request()
                val newUrl = request.url().newBuilder().addQueryParameter("X-RapidAPI-Key", "8497783d3amshc48f76f1c027c3ap19ddb4jsn84a6ac0e523b").build()
                chain.proceed(request.newBuilder().url(newUrl).build())
            }.build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RecipeService::class.java)
        }
    }
}