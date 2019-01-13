package com.triarc.tutorial.android.mvp.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.triarc.tutorial.android.mvp.MainActivity
import com.triarc.tutorial.android.mvp.R
import com.triarc.tutorial.android.mvp.adapter.NameListAdapter
import com.triarc.tutorial.android.mvp.application.MvpTutorialApplication
import com.triarc.tutorial.android.mvp.contract.NameList
import kotlinx.android.synthetic.main.fragment_name_list.*
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListFragment: Fragment(), NameList.View {

    private var rootView: View? = null

    private var names: ArrayList<String>? = null

    private var nameListAdapter: NameListAdapter? = null

    private var recyclerLayoutManager: RecyclerView.LayoutManager? = null

    @Inject
    lateinit var presenter: NameList.Presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        ((activity as? MainActivity)?.application as? MvpTutorialApplication)?.getApplicationComponent()?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater.inflate(R.layout.fragment_name_list, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()

        presenter.checkForData()
    }

    override fun onNameSaved() {
        input.text.clear()
    }

    override fun onInvalidInput(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onUpdateView(name: String?) {
        if(name != null)
            nameListAdapter?.updateList(name)
    }

    override fun onUpdateView(names: ArrayList<String>?) {
        this.names = names
        nameListAdapter?.updateList(this.names)
    }

    override fun onInitialiseView() {
        recyclerLayoutManager = LinearLayoutManager(context)
        recycler_list_view.layoutManager = recyclerLayoutManager
        recycler_list_view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun onInitialiseAdapter() {
        nameListAdapter = NameListAdapter(names)
        recycler_list_view.adapter = nameListAdapter
    }

    override fun onInitialiseListener() {
        save.setOnClickListener {
            presenter.saveName(input.text.toString())
        }
    }
}
