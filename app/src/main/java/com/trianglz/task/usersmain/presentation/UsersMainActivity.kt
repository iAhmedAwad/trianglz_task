package com.trianglz.task.usersmain.presentation

import android.os.Bundle
import com.trianglz.task.R
import dagger.android.support.DaggerAppCompatActivity

class UsersMainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_main)
    }
}
