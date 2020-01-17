package com.yaros.officetime.ui.activity

import android.app.Dialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yaros.officetime.R
import com.yaros.officetime.ui.fragment.GroupFragment
import com.yaros.officetime.ui.fragment.NameFragment
import com.yaros.officetime.ui.fragment.PhotoFragment
import com.yaros.officetime.ui.fragment.WorkInfoFragment

class AddEmployee : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var viewPagerAdapter: ViewPagerAdaper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addemployee)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        init()
        setViewPagerAdapter()
        setTabLayout()
    }

    private fun setTabLayout() {
        tabLayout.setupWithViewPager(viewPager)
        for (i in 0 until viewPagerAdapter.getCount()) { // show steps
            val imgView = ImageView(this)
            imgView.setImageResource(R.drawable.rect)
            if (i == 0) imgView.setColorFilter(
                ContextCompat.getColor(this, R.color.colorAccent),
                PorterDuff.Mode.SRC_IN
            ) else imgView.setColorFilter(
                ContextCompat.getColor(this, android.R.color.darker_gray),
                PorterDuff.Mode.SRC_IN
            )
            tabLayout.getTabAt(i)!!.customView = imgView
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)!!.customView = null

                val imgView = ImageView(this@AddEmployee)
                imgView.setImageResource(R.drawable.rect)
                imgView.setColorFilter(
                    ContextCompat.getColor(this@AddEmployee, R.color.colorAccent),
                    PorterDuff.Mode.SRC_IN
                )
                tabLayout.getTabAt(position)!!.customView = imgView
            }
        })
    }

    private fun setViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdaper(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
    }

    private fun init() {
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabs)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    class ViewPagerAdaper internal constructor(fm: FragmentManager?) :
        FragmentStatePagerAdapter(
            fm!!,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
        var fragmentList: List<Fragment>? = null
        init {
            fragmentList = listOf(NameFragment(),GroupFragment(),PhotoFragment(),WorkInfoFragment())
        }

        override fun getItem(position: Int): Fragment = fragmentList!![position]
        override fun getCount(): Int = fragmentList!!.size
        override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE
    }
}