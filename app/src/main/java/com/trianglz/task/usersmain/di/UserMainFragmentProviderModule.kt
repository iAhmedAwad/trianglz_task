package com.trianglz.task.usersmain.di

import com.trianglz.task.usersmain.presentation.UsersMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class UserMainFragmentProviderModule {

    @UserMainScope
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun contributeUserMainFragment(): UsersMainFragment

}

