package com.trianglz.task.common.di

import com.trianglz.task.usersmain.di.UserMainFragmentProviderModule
import com.trianglz.task.usersmain.presentation.UsersMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [UserMainFragmentProviderModule::class])
    abstract fun contributeUsersMainActivity() : UsersMainActivity
}