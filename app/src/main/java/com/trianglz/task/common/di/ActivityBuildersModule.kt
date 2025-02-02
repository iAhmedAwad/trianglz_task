package com.trianglz.task.common.di

import com.trianglz.task.userdetails.di.UserDetailedFragmentProviderModule
import com.trianglz.task.usersmain.di.UserMainFragmentProviderModule
import com.trianglz.task.usersmain.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [UserMainFragmentProviderModule::class,
            UserDetailedFragmentProviderModule::class]
    )
    abstract fun contributeUsersMainActivity(): MainActivity

}