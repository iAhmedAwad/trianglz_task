package com.trianglz.task.userdetails.di

import com.trianglz.task.userdetails.presentation.UserDetailedFragment
import com.trianglz.task.usersmain.di.UserMainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UserDetailedFragmentProviderModule {

    @UserMainScope
    @ContributesAndroidInjector(modules = [DetailedUserModule::class])
    abstract fun contributeUserMainFragment(): UserDetailedFragment
}