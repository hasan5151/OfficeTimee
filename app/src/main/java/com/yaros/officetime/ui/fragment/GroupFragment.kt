package com.yaros.officetime.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import com.yaros.officetime.R

class GroupFragment : Fragment() {
    lateinit var spinner: AppCompatSpinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.group_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.spinner)


        spinner.adapter = ArrayAdapter<String>(
            context!!,
            R.layout.spinner_layout,
            listOf("Все")
        )

    }
}