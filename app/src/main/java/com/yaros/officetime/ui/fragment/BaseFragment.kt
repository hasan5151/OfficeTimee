package com.yaros.officetime.ui.fragment

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun getName() : String
}