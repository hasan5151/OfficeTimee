package com.yaros.officetime.ui.fragment

import android.app.Dialog
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
import com.yaros.officetime.util.DialogUtil
import com.yaros.officetime.viewModels.RecognizeVM
import org.w3c.dom.Text

class LateFragment : Fragment() {
    lateinit var recognizeVM: RecognizeVM
    lateinit var bottomLayout : LinearLayout
    lateinit var overSleep : TextView
    var dialog : Dialog? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.late_fragment, container, false)

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

        bottomLayout.setOnClickListener({ showDialog() })

    }

    private fun showDialog() {
        dialog  = DialogUtil.bottom(R.layout.dialog_layout,context!!)
        dialog?.show()

        val offDay : TextView = dialog!!.findViewById(R.id.offDay)
        val sick: TextView = dialog!!.findViewById(R.id.sick)
        val writeComment : TextView = dialog!!.findViewById(R.id.writeComment)
        overSleep= dialog!!.findViewById(R.id.offDay) //for  in overSleep for out holiday

        offDay.setOnClickListener({ finish(0)})
        if (::overSleep.isInitialized)
            overSleep.setOnClickListener({finish(1) })
        sick.setOnClickListener({ finish(2)})
        writeComment.setOnClickListener({ write()})
    }

    private fun write() {
        dialog!!.dismiss()
        recognizeVM.comment()
    }

    private fun OutStyle() {
        if (::overSleep.isInitialized)
            overSleep.text=resources.getString(R.string.holiday)
        //TODO change text
    }

    private fun InStyle() {
        if (::overSleep.isInitialized)
            overSleep.text=resources.getString(R.string.oversleep)

        //TODO change text
    }

    private fun finish(type : Int){
        //TODO send reason to server
        recognizeVM.finish()
    }
}