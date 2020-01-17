package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.viewModels.RecognizeVM

class OnTimeFragment : Fragment(){
    lateinit var recognizeVM: RecognizeVM
    lateinit var bottomLayout : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.on_time_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomLayout= view.findViewById(R.id.bottomLayout)


        recognizeVM= ViewModelProviders.of(activity!!).get<RecognizeVM>(RecognizeVM::class.java)

        recognizeVM.startFindFragment.observe(this, Observer {
            when(it){
                SearchFragment.IN -> InStyle()
                SearchFragment.OUT -> OutStyle()
            }
        })

        bottomLayout.setOnClickListener({ recognizeVM.finish()})
    }

    private fun OutStyle() {
        //TODO change text
    }

    private fun InStyle() {
        //TODO change text
    }
}