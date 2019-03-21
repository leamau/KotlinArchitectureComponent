package com.example.architecturecomponent.data.ui.recipes.create

/*
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.architecturecomponent.data.data.model.Recipe
import com.example.architecturecomponent.data.data.RecipeRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.*

class CreateRecipeViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val movieRepository: RecipeRepository by inject()

    var title: MutableLiveData<String> = MutableLiveData()

    var imageUrl: MutableLiveData<String> = MutableLiveData()

    var readyInMinutes: MutableLiveData<Int> = MutableLiveData()

    fun insert() {
        movieRepository.insert(
            Recipe(
                title = title.value?.capitalize() ?: "",
                imageUrl = imageUrl.value?.capitalize() ?: "",
                readyInMinutes = readyInMinutes.value ?: 0
            )
        )
    }
}*/