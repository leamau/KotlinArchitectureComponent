package com.example.architecturecomponent.data.ui.recipes.detail

/*
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dream.architecturecomponents.data.model.Recipe
import com.dream.architecturecomponents.data.RecipeRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class DetailRecipeViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val movieRepository: RecipeRepository by inject()

    var movieId: MutableLiveData<Int> = MutableLiveData()

    var movie: LiveData<Recipe> = Transformations.switchMap(movieId) { id -> movieRepository.getById(id) }
}
*/