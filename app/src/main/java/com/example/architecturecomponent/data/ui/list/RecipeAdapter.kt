package com.example.architecturecomponent.data.ui.list

import com.example.architecturecomponent.data.data.Recipe
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponent.data.data.R
import kotlinx.android.synthetic.main.item_recipe.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class RecipesAdapter: ListAdapter<Recipe, RecipesAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    var onClick: ((item: Recipe) -> Unit)? = null
    var onLongClick: ((item: Recipe) -> Unit)? = null

    //private var data = listOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position), object: OnRecipeClickListener {
            override fun onItemClick(Recipe: Recipe) {
                onClick?.invoke(Recipe)
            }

            override fun onItemLongClick(Recipe: Recipe) {
                onLongClick?.invoke(Recipe)
            }
        })
    }

    class RecipeDiffCallback: DiffUtil.ItemCallback<Recipe>() {

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean = oldItem == newItem

        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean = oldItem.id == newItem.id
    }

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(Recipe: Recipe, onRecipeClickListener: OnRecipeClickListener) {
            itemView.title.text = Recipe.title
            itemView.overview.text = Recipe.readyInMinutes.toString()
            itemView.root.apply {
                onClick { onRecipeClickListener.onItemClick(Recipe)}
                onLongClick { onRecipeClickListener.onItemLongClick(Recipe)}
            }
        }
    }

    interface OnRecipeClickListener {

        fun onItemClick(Recipe: Recipe)

        fun onItemLongClick(Recipe: Recipe)

    }

 /*   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
            RecipeViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_recipe,
                            parent,
                            false
                    )
            )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(data[position], object:
                OnRecipeClickListener {
            override fun onItemClick(recipe: Recipe) {
                onClick?.invoke(recipe)
            }

            override fun onItemLongClick(recipe: Recipe) {
                onLongClick?.invoke(recipe)
            }
        })
    }

    fun replaceData(newData: List<Recipe>) {
        this.data = newData
        notifyDataSetChanged()
    }

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(recipe: Recipe, onRecipeClickListener: OnRecipeClickListener) {
            itemView.title.text = recipe.title
            //itemView.readyInMinutes.text = recipe.readyInMinutes
            itemView.root.apply {
                onClick { onRecipeClickListener.onItemClick(recipe) }
                onLongClick { onRecipeClickListener.onItemLongClick(recipe) }
            }
        }
    }

    interface OnRecipeClickListener {

        fun onItemClick(recipe: Recipe)

        fun onItemLongClick(recipe: Recipe)

    }*/
}