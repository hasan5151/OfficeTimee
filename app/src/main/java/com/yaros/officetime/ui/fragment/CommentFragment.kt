package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.viewModels.RecognizeVM

class CommentFragment : Fragment() {
    lateinit var bottomLayout : LinearLayout
    lateinit var recognizeVM: RecognizeVM
    lateinit var subText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comment_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomLayout= view.findViewById(R.id.bottomLayout)
        subText= view.findViewById(R.id.subText)
        recognizeVM= ViewModelProviders.of(activity!!).get<RecognizeVM>(RecognizeVM::class.java)


        recognizeVM.startFindFragment.observe(this, Observer {
            when(it){
                SearchFragment.IN -> InStyle()
                SearchFragment.OUT -> OutStyle()
            }
        })

        bottomLayout.setOnClickListener({ finishActivity() })
    }

    private fun OutStyle() {
        subText.text =resources.getString(R.string.leavingReason)
     }

    private fun InStyle() {
        subText.text =resources.getString(R.string.lateReason)
     }

    private fun finishActivity() {
        recognizeVM.finish()
    }
}