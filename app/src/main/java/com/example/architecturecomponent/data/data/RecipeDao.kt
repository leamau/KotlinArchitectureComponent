package com.example.architecturecomponent.data.data

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getById(id: Int): Recipe

    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Recipe>)

    @Delete
    fun delete(recipe: Recipe)

}