package com.example.architecturecomponent.data.extensions

import android.app.ActivityOptions
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.architecturecomponent.data.data.R

fun FragmentActivity.startAnimatedActivity(intent: Intent) {
    startActivity(intent, ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_left).toBundle())
}