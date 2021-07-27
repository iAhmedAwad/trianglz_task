package com.trianglz.task.usersmain.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.afollestad.materialdialogs.MaterialDialog
import com.trianglz.task.R
import com.trianglz.task.common.utils.Constants
import com.trianglz.task.common.utils.ErrorChannel
import com.trianglz.task.databinding.FragmentUsersMainBinding
import com.trianglz.task.usersmain.presentation.adapter.UsersAdapter
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class UsersMainFragment : DaggerFragment() {

    private var _binding: FragmentUsersMainBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UsersMainViewModel

    @Inject
    lateinit var adapter: UsersAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initViews() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = this@UsersMainFragment.adapter
            this@UsersMainFragment.adapter.itemClickedCallBack = {
                val navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                val args = Bundle()
                args.putInt(Constants.ID_KEY, it)
                navController.navigate(
                    R.id.userDetailedFragment, args
                )
            }
        }
        viewModel = ViewModelProvider(this, viewModelFactory).get(UsersMainViewModel::class.java)

        viewModel.usersList.observe(viewLifecycleOwner, {
            adapter.submitList(it)

            if (it.isNotEmpty()) {
                binding.swipeToRefresh.isRefreshing = false
            }
        })

        lifecycleScope.launchWhenResumed {

            ErrorChannel.sharedFlow.collect {
                showErrorDialog(it)
            }
        }

    }

    private fun initListeners() {
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getUsers()
        }
    }

    private fun showErrorDialog(message: String): Unit {
        val dialog = MaterialDialog(requireContext())
            .title(R.string.error)
            .message(text = message)
            .icon(R.drawable.ic_error)
            .positiveButton(R.string.ok) {
            }
        dialog.show()
    }
}