package com.triarc.tutorial.android.mvp.di

import com.triarc.tutorial.android.mvp.contract.NameList
import com.triarc.tutorial.android.mvp.model.NameListModel
import com.triarc.tutorial.android.mvp.presenter.NameListPresenter
import com.triarc.tutorial.android.mvp.repository.NameListRepository
import com.triarc.tutorial.android.mvp.storage.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Module
class NameListModule {

    @Provides
    @Singleton
    fun provideNameListModel(repository: NameList.Repository): NameList.Model = NameListModel(repository)

    @Provides
    @Singleton
    fun provideNameListPresenter(model: NameList.Model): NameList.Presenter = NameListPresenter(model)

    @Provides
    @Singleton
    fun provideNameListRepository(preference: PreferenceManager): NameList.Repository = NameListRepository(preference)
}
