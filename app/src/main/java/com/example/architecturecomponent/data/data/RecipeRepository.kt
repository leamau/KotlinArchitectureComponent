package com.example.architecturecomponent.data.data

import android.app.Application
import android.util.Log

object RecipeRepository {

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