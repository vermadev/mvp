package com.triarc.tutorial.android.mvp.repository

import com.triarc.tutorial.android.mvp.contract.NameList
import com.triarc.tutorial.android.mvp.storage.PreferenceManager

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListRepository(private val preference: PreferenceManager): NameList.Repository {

    companion object {
        const val NAME_SET = "name_set"
    }

    override fun saveName(name: String) {
        val nameSet: HashSet<String>? = preference.getStringSet(NAME_SET)
        nameSet?.add(name)
        preference.setStringSet(NAME_SET, nameSet)
    }

    override fun getNames(): ArrayList<String>? {
        val set: HashSet<String>?    = preference.getStringSet(NAME_SET)
        val names: ArrayList<String> = arrayListOf()
        set?.let {nameSet ->
            nameSet.forEach {name ->
                names.add(name)
            }
        }
        return names
    }
}
