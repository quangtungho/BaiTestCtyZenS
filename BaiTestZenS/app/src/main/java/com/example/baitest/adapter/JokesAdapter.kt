package com.example.baitest.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.baitest.DataJokes
import com.example.baitest.R
/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
class JokesAdapter(private val activity: Activity, private val listJoker: ArrayList<DataJokes>) :
    ArrayAdapter<DataJokes>(activity, R.layout.item_list_content) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.item_list_content, parent, false)
        val content = rowView.findViewById<TextView>(R.id.tvContent)
        content.text = listJoker[position].content
        return rowView
    }

    override fun getCount(): Int {
        return 1
    }
}