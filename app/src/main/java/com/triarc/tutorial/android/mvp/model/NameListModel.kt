package com.triarc.tutorial.android.mvp.model

import com.triarc.tutorial.android.mvp.contract.NameList

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListModel(private val repository: NameList.Repository): NameList.Model {

    override fun saveName(name: String) {
        repository.saveName(name)
    }

    override fun getNames(): ArrayList<String>? = repository.getNames()
}
