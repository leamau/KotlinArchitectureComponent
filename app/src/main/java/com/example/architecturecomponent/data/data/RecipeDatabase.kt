package com.example.architecturecomponent.data.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {

        fun buildInstance(context: Context) = Room
                .databaseBuilder(context, RecipeDatabase::class.java, "RecipeDatabase")
                .build()
    }
}