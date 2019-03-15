package com.dream.architecturecomponents

import android.app.Application
import com.example.architecturecomponent.data.data.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import org.jetbrains.anko.doAsync

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        RecipeRepository.initialize(this)


        val recipes = listOf(
                Recipe(id = 1, title = "Avengers", readyInMinutes = 10),
                Recipe(id = 2, title = "Jumanji", readyInMinutes = 15),
                Recipe(id = 3, title = "Conjuring: Les dossiers Warren", readyInMinutes = 20)
        )

        doAsync { RecipeRepository.insertAll(recipes) }
    }
}