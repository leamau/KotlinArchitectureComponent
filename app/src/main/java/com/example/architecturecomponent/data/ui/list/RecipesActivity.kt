package com.example.architecturecomponent.data.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponent.data.data.R
import com.example.architecturecomponent.data.data.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import com.example.architecturecomponent.data.extensions.startAnimatedActivity
import com.example.architecturecomponent.data.ui.create.CreateRecipeActivity
import com.example.architecturecomponent.data.ui.detail.DetailRecipeActivity
import kotlinx.android.synthetic.main.activity_recipes.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class RecipesActivity : AppCompatActivity() {

    private var recipesAdapter = RecipesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        setupAdapter()
        setupFab()
        setupRecyclerView()
    }

    /*override fun onResume() {
        super.onResume()
        doAsync {
            val data = RecipeRepository.getAll()
            uiThread { recipesAdapter.replaceData(data) }
        }
    }*/

    private fun setupAdapter() {
        recipesAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<DetailRecipeActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    private fun setupFab() {
        fab.onClick { startAnimatedActivity(intentFor<CreateRecipeActivity>()) }
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@RecipesActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@RecipesActivity)
            adapter = recipesAdapter
        }
    }

    private fun showDeletePopup(Recipe: Recipe) {
        alert(getString(R.string.delete_recipe_warning, Recipe.title)) {
            yesButton { RecipeRepository.delete(Recipe) }
            noButton { }
        }.show()
    }

    /*
    private fun showDeletePopup(recipe: Recipe) {
        alert(getString(R.string.delete_recipe_warning, recipe.title)) {
            yesButton {
                doAsync {
                    RecipeRepository.delete(recipe)
                    val data = RecipeRepository.getAll()
                    uiThread { recipesAdapter.replaceData(data) }
                }
            }
            noButton { }
        }.show()
    }*/
}
