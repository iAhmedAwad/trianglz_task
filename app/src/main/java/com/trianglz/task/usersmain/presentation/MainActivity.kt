package com.trianglz.task.usersmain.presentation

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.MaterialDialog
import com.trianglz.task.R
import com.trianglz.task.common.utils.ErrorChannel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.flow.collect

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initViews(){
        lifecycleScope.launchWhenResumed {

            ErrorChannel.sharedFlow.collect {
                showErrorDialog(it)
            }
        }
    }


    private fun showErrorDialog(message: String): Unit {
        val dialog = MaterialDialog(this)
            .title(R.string.error)
            .message(text = message)
            .icon(R.drawable.ic_error)
            .positiveButton(R.string.ok) {
            }
        dialog.show()
    }
}

