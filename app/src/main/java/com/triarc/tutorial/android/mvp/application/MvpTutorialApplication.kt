package com.triarc.tutorial.android.mvp.application

import android.app.Application
import com.triarc.tutorial.android.mvp.di.ApplicationComponent
import com.triarc.tutorial.android.mvp.di.ApplicationContextModule
import com.triarc.tutorial.android.mvp.di.DaggerApplicationComponent
import com.triarc.tutorial.android.mvp.di.NameListModule

/**
 * Created by Devanshu Verma on 13/1/19
 */
class MvpTutorialApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .nameListModule(NameListModule())
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getApplicationComponent() = applicationComponent
}
