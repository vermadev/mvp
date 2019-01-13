package com.triarc.tutorial.android.mvp.contract

import com.triarc.tutorial.android.mvp.base.BasePresenter
import com.triarc.tutorial.android.mvp.base.BaseView

/**
 * Created by Devanshu Verma on 13/1/19
 */
interface NameList {
    interface View: BaseView {
        fun onNameSaved()
        fun onUpdateView(name: String?)
        fun onUpdateView(names: ArrayList<String>?)
        fun onInvalidInput(message: String)
        fun onInitialiseView()
        fun onInitialiseAdapter()
        fun onInitialiseListener()
    }

    interface Model {
        fun saveName(name: String)
        fun getNames(): ArrayList<String>?
    }

    interface Presenter: BasePresenter<View> {
        fun saveName(name: String?)
        fun checkForData()
    }

    interface Repository {
        fun saveName(name: String)
        fun getNames(): ArrayList<String>?
    }
}
