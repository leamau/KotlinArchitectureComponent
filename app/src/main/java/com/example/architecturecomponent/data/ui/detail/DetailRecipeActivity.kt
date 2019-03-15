package com.dream.architecturecomponents.ui.movies.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.architecturecomponent.R
import com.example.architecturecomponent.data.data.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import kotlinx.android.synthetic.main.activity_detail_recipe.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
class DetailRecipeActivity : AppCompatActivity() {

    private var recipe: Recipe? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)

        doAsync {
            recipe = RecipeRepository.getById(intent.getIntExtra("id", 0) )
            uiThread {
                setupToolbar()
                setupViews()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        title = recipe?.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViews() {
        recipe?.let { recipe ->
            readyInMinutes.text = getString(recipe.readyInMinutes)
        }
    }
}
