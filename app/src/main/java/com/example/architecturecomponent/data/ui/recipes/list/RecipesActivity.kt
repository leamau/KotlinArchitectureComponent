package com.example.architecturecomponent.data.ui.recipes.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponent.data.R
import com.example.architecturecomponent.data.data.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import com.example.architecturecomponent.data.extensions.startAnimatedActivity
import com.example.architecturecomponent.data.ui.recipes.create.CreateRecipeActivity
import com.example.architecturecomponent.data.ui.recipes.detail.DetailRecipeActivity
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

    override fun onResume() {
        super.onResume()
        doAsync {
            val data = RecipeRepository.getAll()
            uiThread { recipesAdapter.replaceData(data) }
        }
    }

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
    }
}

/*

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dream.architecturecomponents.R
import com.dream.architecturecomponents.data.model.Recipe
import com.dream.architecturecomponents.data.remote.RecipesResponseCallback
import com.dream.architecturecomponents.databinding.ActivityRecipeBinding
import com.dream.architecturecomponents.databinding.ActivityRecipesBinding
import com.dream.architecturecomponents.extension.startAnimatedActivity
import com.dream.architecturecomponents.ui.base.BaseActivity
import com.dream.architecturecomponents.ui.recipes.create.CreateRecipeActivity
import com.dream.architecturecomponents.ui.recipes.detail.DetailRecipeActivity
import org.jetbrains.anko.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesActivity : BaseActivity<RecipesViewModel, ActivityRecipesBinding>() {

    override val layout: Int = R.layout.activity_recipes

    override val viewModel: RecipesViewModel by viewModel()

    private var recipesAdapter = RecipesAdapter(this)

    override fun initView(savedInstanceState: Bundle?) {
        setupAdapter()
        setupFab()
        setupRecyclerView()
        setupSwipeRefreshLayout()
    }

    private fun setupAdapter() {
        viewModel.recipes.observe(this, Observer {
            recipesAdapter.submitList(it)
        })

        recipesAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<DetailRecipeActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    private fun setupFab() {
        binding.fab.onClick { startAnimatedActivity(intentFor<CreateRecipeActivity>()) }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@RecipesActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@RecipesActivity)
            adapter = recipesAdapter
        }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.apply {

            fun refresh() {
                isRefreshing = true
                viewModel.refresh(object: RecipesResponseCallback {
                    override fun onSuccess() {
                        binding.root.showAction(getString(R.string.movies_loaded))
                        isRefreshing = false
                    }

                    override fun onError(throwable: Throwable) {
                        binding.root.showError(getString(R.string.movies_loading_error))
                        isRefreshing = false
                    }
                })
            }

            setOnRefreshListener { refresh() }
            post { refresh() }
        }
    }

    private fun showDeletePopup(recipe: Recipe) {
        alert(getString(R.string.delete_movie_warning, movie.title)) {
            yesButton { viewModel.delete(recipe) }
            noButton { }
        }.show()
    }
}
*/