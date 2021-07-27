package com.trianglz.task.userdetails.di

import androidx.lifecycle.ViewModel
import com.trianglz.task.userdetails.data.repository.SingleUserRepoImpl
import com.trianglz.task.userdetails.domain.repository.SingleUserRepo
import com.trianglz.task.userdetails.presentation.UserDetailedViewModel
import com.trianglz.task.usersmain.data.service.GetSingleUserService
import com.trianglz.task.usersmain.di.UserMainScope
import com.trianglz.task.usersmain.presentation.UsersMainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import retrofit2.Retrofit


@Module
abstract class DetailedUserModule {

    @Binds
    @IntoMap
    @ClassKey(UsersMainViewModel::class)
    abstract fun bindMovieViewModel(viewModel: UserDetailedViewModel): ViewModel


    @UserMainScope
    @Binds
    abstract fun bindUserRepo(singleUserRepoImpl: SingleUserRepoImpl): SingleUserRepo

    companion object {
        @UserMainScope
        @Provides

        fun getSingleUserService(
            retrofit: Retrofit
        ): GetSingleUserService = retrofit.create(GetSingleUserService::class.java)
    }
}