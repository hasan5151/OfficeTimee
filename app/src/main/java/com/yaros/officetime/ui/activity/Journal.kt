package com.yaros.officetime.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yaros.officetime.R
import com.yaros.officetime.ui.fragment.*

class Journal: AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdaper
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.journal)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        init()
        setViewPagerAdapter()
        setTabLayout()
     }

    class ViewPagerAdaper internal constructor(fm: FragmentManager?) :
        FragmentStatePagerAdapter(
            fm!!,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
        var fragmentList: List<BaseFragment>? = null
        init {
            fragmentList = listOf(
                AtPlaceFragment(),
                Absent()
            )
        }

        override fun getItem(position: Int): Fragment = fragmentList!![position]
        override fun getCount(): Int = fragmentList!!.size
        override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE
        override fun getPageTitle(position: Int): CharSequence? = fragmentList!!.get(position).getName()


    }

    private fun init() {
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabs)
    }

    private fun setTabLayout() {
        tabLayout.setupWithViewPager(viewPager)
        for (i in 0 until viewPagerAdapter.getCount()) { // show steps
            tabLayout.getTabAt(i)?.text= viewPagerAdapter.getPageTitle(i)
        }
    }

    private fun setViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdaper(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}