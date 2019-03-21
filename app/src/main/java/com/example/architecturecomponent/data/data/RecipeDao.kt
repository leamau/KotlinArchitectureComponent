package com.example.architecturecomponent.data.data

import androidx.lifecycle.LiveData
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


/*
    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getById(id: Int): LiveData<Recipe>

    @Query("SELECT * FROM recipe")
    fun getAllLive(): LiveData<List<Recipe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Recipe>)

    @Delete
    fun delete(recipe: Recipe)*/

}