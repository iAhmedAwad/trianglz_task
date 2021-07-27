package com.trianglz.task.common.di

import com.trianglz.task.usersmain.presentation.UsersMainActivity
import com.trianglz.task.usersmain.di.UserModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun contributeUsersMainActivity() : UsersMainActivity
}