package com.yaros.officetime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaros.officetime.R

class PersonAdapter(val stringList :List<String>)  : RecyclerView.Adapter<PersonAdapter.PersonVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonVH {
        val view: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_person, parent, false)
        return PersonVH(view)
    }

    override fun getItemCount(): Int = stringList.size


    override fun onBindViewHolder(holder: PersonVH, position: Int) {
        //
    }

    class PersonVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //
    }

}