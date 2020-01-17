package com.yaros.officetime.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import com.yaros.officetime.R

class WorkInfoFragment : Fragment() {
    lateinit var startSpinner: AppCompatSpinner
    lateinit var finishSpinner: AppCompatSpinner
    lateinit var lateSpinner: AppCompatSpinner
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.work_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        setStartSpinner()
        setFinishSpinner()
        setLateSpinner()
    }

    private fun setFinishSpinner() {
        finishSpinner.adapter =  ArrayAdapter<String>(
            context!!,
            R.layout.spinner_layout,
            listOf("17:00","17:30","18:00")
        )

    }

    private fun setLateSpinner() {
        lateSpinner.adapter =  ArrayAdapter<String>(
            context!!,
            R.layout.spinner_layout,
            List(60) {
                it.toString()
            }
        )
        //(1..100).map { Random.nextInt() }

    }

    private fun setStartSpinner() {
        startSpinner.adapter =  ArrayAdapter<String>(
            context!!,
            R.layout.spinner_layout,
            listOf("9:00","9:30","10:00")
        )
    }

    private fun init(view: View) {
        startSpinner = view.findViewById(R.id.startSpinner)
        finishSpinner = view.findViewById(R.id.finishSpinner)
        lateSpinner = view.findViewById(R.id.lateSpinner)
    }
}