package com.trianglz.task.usersmain.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.ShimmerFrameLayout
import com.trianglz.task.R
import com.trianglz.task.databinding.ItemUserBinding
import com.trianglz.task.databinding.ShimmerItemUserBinding
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import com.trianglz.task.usersmain.presentation.models.BaseUserPresentationModel
import com.trianglz.task.usersmain.presentation.models.ShimmerUserPresentationModel
import javax.inject.Inject

class UsersAdapter @Inject constructor() :
    ListAdapter<BaseUserPresentationModel, RecyclerView.ViewHolder>(UserDiffUtil()) {

    var itemClickedCallBack = { _: Int -> Unit }


    inner class MyViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(userDomainModel: UserDomainModel) {
            binding.apply {

                nameTv.text = userDomainModel.name
                emailTv.text = userDomainModel.email
                Glide.with(root.context).load(userDomainModel.imageUrl).into(imageView)
                root.setOnClickListener {
                    this@UsersAdapter.itemClickedCallBack.invoke(userDomainModel.id)
                }
            }

        }

    }

    inner class ShimmerViewHolder(private val binding: ShimmerItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.children.filterIsInstance<ShimmerFrameLayout>().forEach {
                it.startShimmer()
            }
        }

    }

    override fun getItemViewType(position: Int): Int {

        if(getItem(position) is ShimmerUserPresentationModel)
            return R.layout.shimmer_item_user
        else
            return R.layout.item_user
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  RecyclerView.ViewHolder {

        when(viewType){
              R.layout.shimmer_item_user ->{
                  val binding = ShimmerItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                  return ShimmerViewHolder(binding)
            }else->{
            val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder, position: Int) {
        (holder as? MyViewHolder)?.bindViews(getItem(position) as UserDomainModel)
    }

    private class UserDiffUtil : DiffUtil.ItemCallback<BaseUserPresentationModel>() {
        override fun areItemsTheSame(
            oldItem: BaseUserPresentationModel,
            newItem: BaseUserPresentationModel
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: BaseUserPresentationModel,
            newItem: BaseUserPresentationModel
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }
}