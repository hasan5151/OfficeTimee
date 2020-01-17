package com.yaros.officetime.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.ui.fragment.SearchFragment.Companion.IN
import com.yaros.officetime.ui.fragment.SearchFragment.Companion.OUT
import com.yaros.officetime.viewModels.RecognizeVM
import kotlinx.android.synthetic.main.find_fragment.*

class FindFragment : Fragment() {
    lateinit var recognizeVM: RecognizeVM
    lateinit var button : Button
    lateinit var img : ImageView
    lateinit var bottomLayout : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.find_fragment, container, false)
     }

    companion object{
        const  val ONTIME= 1
        const  val LATE= 2
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.bottomTxt)
        img= view.findViewById(R.id.bottomIcon)
        bottomLayout= view.findViewById(R.id.bottomLayout)

        recognizeVM= ViewModelProviders.of(activity!!).get<RecognizeVM>(RecognizeVM::class.java)
        recognizeVM.startFindFragment.observe(this, Observer {
            when(it){
                IN -> InStyle()
                OUT -> OutStyle()
            }
        })

        bottomLayout.setOnClickListener({ recognizeVM.result(LATE) })
    }


    private fun InStyle(){
        System.out.println("in style")
        img.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.inn))
        button.text= resources.getString(R.string.recordcoming)
    }
    private fun OutStyle(){
        System.out.println("out style")

        img.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.out))
        button.text= resources.getString(R.string.recordexit)
    }

}