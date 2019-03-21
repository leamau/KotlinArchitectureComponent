package com.example.architecturecomponent.data.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {

        fun buildInstance(context: Context) = Room
                .databaseBuilder(context, RecipeDatabase::class.java, "RecipeDatabase")
                .build()
    }
}

/*
@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        const val DATABASE_NAME = "RecipeDatabase"
    }
}*/