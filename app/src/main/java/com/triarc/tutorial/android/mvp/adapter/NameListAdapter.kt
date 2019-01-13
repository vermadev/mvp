package com.triarc.tutorial.android.mvp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.triarc.tutorial.android.mvp.R
import com.triarc.tutorial.android.mvp.adapter.viewholder.NameListViewHolder

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListAdapter(private var names: ArrayList<String>?): RecyclerView.Adapter<NameListViewHolder>()  {

    companion object ViewType {
        const val ITEM   = 1
        const val FOOTER = 2
    }

    fun updateList(name: String) {
        if(names == null)
            names = arrayListOf()

        names?.add(name)
        notifyDataSetChanged()
    }

    fun updateList(names: ArrayList<String>?) {
        this.names = names
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = names?.size ?: 0

    override fun getItemViewType(position: Int): Int = if (names?.get(position) != null) ITEM else FOOTER

    override fun onBindViewHolder(viewHolder: NameListViewHolder, position: Int) {
        viewHolder.name.text = names?.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_name, parent, false)
        return NameListViewHolder(view)
    }
}
