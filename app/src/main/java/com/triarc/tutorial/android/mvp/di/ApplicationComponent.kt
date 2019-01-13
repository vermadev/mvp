package com.triarc.tutorial.android.mvp.di

import com.triarc.tutorial.android.mvp.view.NameListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Singleton
@Component(modules = [NameListModule::class, ApplicationContextModule::class])
interface ApplicationComponent {

    fun inject(target: NameListFragment)
}
