package com.trianglz.task.usersmain.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.training.movies_clean.databinding.ItemMovieBinding
import com.training.movies_clean.movies.domain.models.MovieDomainModel
import com.trianglz.task.databinding.ItemUserBinding
import com.trianglz.task.usersmain.domain.models.UserDomainModel
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : ListAdapter<UserDomainModel, MoviesAdapter.MyViewHolder>(MoviesDiffUtil()) {

    private lateinit var binding: ItemUserBinding

    class MyViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(userDomainModel: UserDomainModel) {
            binding.textViewMovieName.text = movieDomainModel.movieName
            binding.textViewMovieId.text = movieDomainModel.movieId

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViews(getItem(position))
    }

    private class MoviesDiffUtil : DiffUtil.ItemCallback<MovieDomainModel>() {
        override fun areItemsTheSame(
            oldItem: MovieDomainModel,
            newItem: MovieDomainModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MovieDomainModel,
            newItem: MovieDomainModel
        ): Boolean {
            return oldItem.movieId.equals(newItem.movieId) && oldItem.movieName.equals(newItem.movieName)
        }

    }
}