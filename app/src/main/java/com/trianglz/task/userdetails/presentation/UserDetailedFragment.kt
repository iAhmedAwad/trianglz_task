package com.trianglz.task.userdetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trianglz.task.databinding.FragmentUsersMainBinding
import javax.inject.Inject

class UserDetailedFragment : Fragment() {


    private var _binding: FragmentUsersMainBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private lateinit var viewModel: UserDetailedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}