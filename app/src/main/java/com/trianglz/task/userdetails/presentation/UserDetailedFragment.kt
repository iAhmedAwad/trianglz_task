package com.trianglz.task.userdetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.trianglz.task.common.utils.Constants
import com.trianglz.task.databinding.UserDetailedFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserDetailedFragment : DaggerFragment() {

    private var _binding: UserDetailedFragmentBinding? = null

    private val binding get() = _binding!!

    private val userId by lazy {
        arguments?.getInt(Constants.ID_KEY)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserDetailedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserDetailedFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun initViews(){

        viewModel = ViewModelProvider(this, viewModelFactory).get(UserDetailedViewModel::class.java)
        viewModel.userId = userId
        viewModel.getUser()
        viewModel.detailedUser.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.apply {
                    nameDetailedTv.text=it.name
                    emailDetailedTv.text = it.email
                    Glide.with(root.context).load(it.imageUrl).into(imageView)
                }
            }

        })

    }

}