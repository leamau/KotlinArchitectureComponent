package com.example.architecturecomponent.data.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.architecturecomponent.data.data.remote.RecipeResponse
import com.example.architecturecomponent.data.data.remote.RecipeService
import com.example.architecturecomponent.data.data.remote.RecipesResponseCallback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.koin.standalone.inject

object RecipeRepository {
 /*   private val recipeDao: RecipeDao by inject()

    private val service = RecipeService.create()

    //region locale

    fun insertAll(recipes: List<Recipe>) = doAsync {
        recipeDao.insertAll(recipes)
        Log.d("movieRepository","inserting recipes: $recipes")
    }

    fun insert(recipe: Recipe) =
        insertAll(listOf(recipe))

    fun delete(recipe: Recipe) = doAsync { recipeDao.delete(recipe) }

    fun getById(id: Int): LiveData<Recipe> = recipeDao.getById(id)

    fun getAll(): LiveData<List<Recipe>> = recipeDao.getAllLive()

    //endregion

    //region remote

    fun downloadRecipes(callback: RecipesResponseCallback) {
        service.getRecipes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { recipesListResponse -> insertAll(recipesListResponse.results.map { recipeResponse -> recipeResponseToRecipe(recipeResponse) }) },
                onComplete = { callback.onSuccess() },
                onError = { callback.onError(it) }
            )
    }

    fun downloadRecipesWithExtraInfos(callback: RecipesResponseCallback) {
        service.getRecipes()
            .subscribeOn(Schedulers.io())
            .flatMap { recipesListResponse -> Observable.fromIterable(recipesListResponse.results) }
            .flatMap { recipeShortResponse -> service.getRecipe(recipeShortResponse.id) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { recipeFullResponse -> insert(recipeResponseToRecipe(recipeFullResponse)) },
                onComplete = { callback.onSuccess() },
                onError = { callback.onError(it) }
            )
    }

    private fun recipeResponseToRecipe(recipeResponse: RecipeResponse): Recipe =
        Recipe(
            id = recipeResponse.id,
            title = recipeResponse.title,
            imageUrl = recipeResponse.backdropPath,
            readyInMinutes = recipeResponse.readyInMinutes.toInt()
        )

    //endregion
*/



    private lateinit var database: RecipeDatabase

    private lateinit var recipeDao: RecipeDao

    fun initialize(application: Application) {
        database = RecipeDatabase.buildInstance(application)
        recipeDao = database.recipeDao()
    }

    fun insertAll(recipes: List<Recipe>) {
        recipes.forEach { recipe -> if(recipe.id == 0) recipe.id = (getAll().maxBy { it.id }?.id ?: 0) + 1 }
        recipeDao.insertAll(recipes)
        Log.d("recipeRepository","inserting recipes: $recipes")
    }

    fun insert(recipe: Recipe) = insertAll(listOf(recipe))

    fun delete(recipe: Recipe) {
        recipeDao.delete(recipe)
    }

    fun getById(id: Int): Recipe = recipeDao.getById(id)

    fun getAll(): List<Recipe> = recipeDao.getAll()
}