package com.trianglz.task.usersmain.di

import androidx.lifecycle.ViewModel
import com.trianglz.task.usersmain.data.repository.UserRepoImpl
import com.trianglz.task.usersmain.data.service.GetUsersService
import com.trianglz.task.usersmain.presentation.UsersMainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class UserModule {


    @UserMainScope
    @Binds
    abstract fun bindPopularMoviesRepo(userRepoImpl: UserRepoImpl): UserRepoImpl


    @Binds
    @IntoMap
    @ClassKey(UsersMainViewModel::class)
    abstract fun bindMovieViewModel(viewModel: UsersMainViewModel): ViewModel



    companion object {
        @UserMainScope
        @Provides

        fun getPopularMoviesService(
            retrofit: Retrofit
        ): GetUsersService = retrofit.create(GetUsersService::class.java)
    }
}