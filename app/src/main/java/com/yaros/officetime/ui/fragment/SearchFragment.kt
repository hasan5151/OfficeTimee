package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.viewModels.RecognizeVM


class SearchFragment : Fragment(){
    lateinit var recognizeVM : RecognizeVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    companion object{
        const  val IN = 1
        const  val OUT = 2
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recognizeVM= ViewModelProviders.of(activity!!).get<RecognizeVM>(RecognizeVM::class.java)

        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                searchFinished()
            }

            override fun onTick(millisUntilFinished: Long) {
                println("%$millisUntilFinished")
            }
        }.start()
    }

    private fun searchFinished() {
        recognizeVM.findFragment(OUT)
    }
}