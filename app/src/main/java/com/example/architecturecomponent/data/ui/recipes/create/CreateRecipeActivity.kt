package com.example.architecturecomponent.data.ui.recipes.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.architecturecomponent.data.R
import com.example.architecturecomponent.data.data.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import kotlinx.android.synthetic.main.activity_create_recipe.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.textChangedListener
import org.jetbrains.anko.uiThread

class CreateRecipeActivity : AppCompatActivity() {

    private var recipe = Recipe()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recipe)

        /*   setupToolbar()*/
           setupViews()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_recipe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        R.id.confirm -> {
            doAsync {
                RecipeRepository.insert(recipe)
                uiThread { ActivityCompat.finishAfterTransition(this@CreateRecipeActivity) }
            }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    /*  private fun setupToolbar() {
          setSupportActionBar(toolbar)
          supportActionBar?.setDisplayHomeAsUpEnabled(true)
      }*/
      private fun setupViews() {
          titleEditText.apply {
              requestFocus()
              textChangedListener { onTextChanged { charSequence, _, _, _ -> recipe.title = charSequence.toString().capitalize() } }
          }

      }

}
