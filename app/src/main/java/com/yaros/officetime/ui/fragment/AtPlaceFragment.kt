package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaros.officetime.R
import com.yaros.officetime.adapter.PersonAdapter

class AtPlaceFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.atplace, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        var personAdapter: PersonAdapter? = PersonAdapter(listOf("",""))
        recyclerView.adapter = personAdapter
    }


    override fun getName(): String = "На Месте"
}