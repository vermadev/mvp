package com.triarc.tutorial.android.mvp.presenter

import android.text.TextUtils
import com.triarc.tutorial.android.mvp.base.AbstractBasePresenter
import com.triarc.tutorial.android.mvp.contract.NameList

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListPresenter(private val model: NameList.Model): AbstractBasePresenter<NameList.View>(), NameList.Presenter  {

    override fun attachView(view: NameList.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun saveName(name: String?) {
        if(name == null)
            getView()?.onInvalidInput("Invalid input, name can not be null")
        else {
            if(TextUtils.isEmpty(name)) {
                getView()?.onInvalidInput("Invalid input, name can not be empty")
            } else {
                model.saveName(name)
                getView()?.onNameSaved()
                getView()?.onUpdateView(model.getNames())
            }
        }
    }

    override fun checkForData() {
        getView()?.onUpdateView(model.getNames())
    }
}
