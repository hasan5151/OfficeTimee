package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.viewModels.RecognizeVM

class RecognizeFragment: PhotoFragment() {
    lateinit var recognizeVM : RecognizeVM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoBtn.text = context!!.resources.getString(R.string.recognize)
        recognizeVM= ViewModelProviders.of(activity!!).get<RecognizeVM>(RecognizeVM::class.java)

    }


    override fun takePhoto(view: View) {
        recognizeVM.searchFragment()
         // super.takePhoto(view)
    }
}