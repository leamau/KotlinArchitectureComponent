package com.example.architecturecomponent.data.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe")
data class Recipe(

        @PrimaryKey
        override var id: Int = 0,

        var title: String = "Sans titre",

        var readyInMinutes: Int = 0,

        var imageUrl: String? = null

): BaseObject