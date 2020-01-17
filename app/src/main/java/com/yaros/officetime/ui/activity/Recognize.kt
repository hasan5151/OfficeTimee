package com.yaros.officetime.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yaros.officetime.R
import com.yaros.officetime.ui.fragment.*
import com.yaros.officetime.ui.fragment.FindFragment.Companion.LATE
import com.yaros.officetime.ui.fragment.FindFragment.Companion.ONTIME
import com.yaros.officetime.viewModels.RecognizeVM

class Recognize : AppCompatActivity() {

    lateinit var recognizeVM: RecognizeVM
    lateinit var ft : FragmentTransaction
    var type = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recognize)
        setRecognizeFragment(savedInstanceState)
        recognizeVM= ViewModelProviders.of(this).get(RecognizeVM::class.java)
        startSearchFragment()
        startFindFragment()
        startResultFragment()
        checkFinish()
        startCommentFragment()
    }

    private fun startCommentFragment() {
        recognizeVM.startCommentFragment.observe(this, Observer {
            startFragment(CommentFragment())
        })
    }

    private fun checkFinish() {
        recognizeVM.finishActivity.observe(this, Observer {
            val intent = Intent()
            intent.putExtra("type", type)
            setResult(RESULT_OK, intent)
            finish()
        })
    }

    private fun startResultFragment() {
        recognizeVM.selectResultFragment.observe(this, Observer {
            when(it){
                ONTIME ->{startFragment(OnTimeFragment())}
                LATE ->{startFragment(LateFragment())}
            }
        })
    }

    private fun startFindFragment() {
        recognizeVM.startFindFragment.observe(this, Observer {
            type=it
            startFragment(FindFragment()) })
    }

    private fun startSearchFragment() {
        recognizeVM.startSearchFragment.observe(this, Observer {startFragment(SearchFragment())})
    }

    private fun setRecognizeFragment(savedInstanceState: Bundle?) {
        val manager = supportFragmentManager
        ft = manager.beginTransaction()

        if (savedInstanceState == null) {
            ft.replace(R.id.container, RecognizeFragment())
            ft.commitAllowingStateLoss()
        }
    }

    private  fun startFragment (fragment : Fragment){
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        ft.replace(R.id.container, fragment)
        ft.commitAllowingStateLoss()
    }
}