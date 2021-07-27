package com.trianglz.task.usersmain.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trianglz.task.databinding.ItemUserBinding
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import javax.inject.Inject

class UsersAdapter @Inject constructor() :
    ListAdapter<UserDomainModel, UsersAdapter.MyViewHolder>(UserDiffUtil()) {

    var itemClickedCallBack = { _: UserDomainModel? -> Unit }
    private lateinit var binding: ItemUserBinding



    class MyViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(userDomainModel: UserDomainModel) {
            binding.apply {

                nameTv.text = userDomainModel.name
                emailTv.text = userDomainModel.email
                Glide.with(root.context).load(userDomainModel.imageUrl).into(imageView)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViews(getItem(position))
    }

    private class UserDiffUtil : DiffUtil.ItemCallback<UserDomainModel>() {
        override fun areItemsTheSame(
            oldItem: UserDomainModel,
            newItem: UserDomainModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserDomainModel,
            newItem: UserDomainModel
        ): Boolean {
            return oldItem.email == newItem.email
        }

    }
}