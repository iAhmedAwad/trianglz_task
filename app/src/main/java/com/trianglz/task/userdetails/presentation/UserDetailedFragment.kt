package com.trianglz.task.userdetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trianglz.task.R

class UserDetailedFragment : Fragment() {

    companion object {
        fun newInstance() = UserDetailedFragment()
    }

    private lateinit var viewModel: UserDetailedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_detailed_fragment, container, false)
    }



}