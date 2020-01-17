package com.yaros.officetime.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.yaros.officetime.R

open class PhotoFragment : Fragment() {
    lateinit var linearLayout: LinearLayout
    protected lateinit var photoBtn :Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayout = view.findViewById(R.id.bottomLayout)
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val againView = inflater.inflate(R.layout.again_layout, null)
        val takePhotoView = inflater.inflate(R.layout.take_photo, null)

        val takePhoto : LinearLayout = takePhotoView.findViewById(R.id.takePhotoLayout)
        photoBtn  = takePhotoView.findViewById(R.id.photoBtn)

        /*linearLayout.removeAllViews()
        linearLayout.addView(view)*/

        linearLayout.removeAllViews()
        linearLayout.addView(takePhotoView)

        takePhoto.setOnClickListener(this::takePhoto)
    }

    protected open fun takePhoto(view: View){

    }


 }