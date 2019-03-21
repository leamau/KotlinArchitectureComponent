package com.example.architecturecomponent.data.ui.base

/*
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import com.example.architecturecomponent.data.BR
import com.example.architecturecomponent.data.R
import com.example.architecturecomponent.data.ui.recipes.list.RecipesActivity

abstract class BaseActivity<V: AndroidViewModel, B: ViewDataBinding>: AppCompatActivity() {

    protected abstract val layout: Int

    protected abstract val viewModel: V

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)

        initView(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> { super.onOptionsItemSelected(item) }
    }

    override fun finish() {
        super.finish()
        if (this !is RecipesActivity) overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    protected abstract fun initView(savedInstanceState: Bundle?)

}*/