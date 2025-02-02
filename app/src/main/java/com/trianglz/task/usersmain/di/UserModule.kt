package com.trianglz.task.usersmain.di

import androidx.lifecycle.ViewModel
import com.trianglz.task.usersmain.data.repository.UserRepoImpl
import com.trianglz.task.usersmain.data.service.GetUsersService
import com.trianglz.task.usersmain.domain.repository.UsersRepo
import com.trianglz.task.usersmain.presentation.UsersMainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class UserModule {




    @Binds
    @IntoMap
    @ClassKey(UsersMainViewModel::class)
    abstract fun bindMovieViewModel(viewModel: UsersMainViewModel): ViewModel


    @UserMainScope
    @Binds
    abstract fun bindUserRepo(userRepoImpl: UserRepoImpl): UsersRepo

    companion object {
        @UserMainScope
        @Provides

        fun getUsersService(
            retrofit: Retrofit
        ): GetUsersService = retrofit.create(GetUsersService::class.java)
    }
}