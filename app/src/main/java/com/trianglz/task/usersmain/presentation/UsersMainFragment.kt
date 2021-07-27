package com.trianglz.task.usersmain.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trianglz.task.databinding.FragmentUsersMainBinding


class UsersMainFragment : Fragment() {

    private var _binding: FragmentUsersMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersMainBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

}