package com.example.architecturecomponent.data.ui.recipes.list
/*
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dream.architecturecomponents.data.RecipeRepository
import com.dream.architecturecomponents.data.model.Recipe
import com.dream.architecturecomponents.data.remote.RecipesResponseCallback
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class RecipesViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val recipeRepository: RecipeRepository by inject()

    var recipes: LiveData<List<Recipe>> = recipeRepository.getAll()

    fun delete(recipe: Recipe) {
        recipeRepository.delete(recipe)
    }

    fun refresh(callback: RecipesResponseCallback) {
        recipeRepository.downloadRecipes(callback)
    }
}*/