package com.yaros.officetime.ui.activity

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.yaros.officetime.R
import com.yaros.officetime.ui.fragment.SearchFragment.Companion.IN
import com.yaros.officetime.ui.fragment.SearchFragment.Companion.OUT

class Start : AppCompatActivity (), NavigationView.OnNavigationItemSelectedListener, View.OnTouchListener,
    View.OnClickListener {
    lateinit var enter : ImageView
    lateinit var icon : ImageView
    lateinit var enterTxt: Button
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var info: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)
        init()
        setToolbar()
        setDrawerLayout()
        setNavigationDrawer()
        onButtonClick()
    }

    private fun init() {
        enter = findViewById(R.id.enter)
        icon = findViewById(R.id.icon)
        enterTxt = findViewById(R.id.enterTxt)
        toolbar=  findViewById(R.id.toolbar)
        drawerLayout= findViewById(R.id.drawer_layout)
        info= findViewById(R.id.info)
    }

    private fun setNavigationDrawer() {
        val navigationView: NavigationView = findViewById(R.id.nav)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun setDrawerLayout() {
        val toggle =
            ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
        try {
            drawerLayout.addDrawerListener(toggle)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        toggle.syncState()    }

    private fun setToolbar() {
        toolbar.bringToFront()
        setSupportActionBar(toolbar)
    }

    private fun onButtonClick() {
        enter.setOnTouchListener(this)
        icon.setOnTouchListener(this)
        enter.setOnTouchListener(this)

        enter.setOnClickListener(this)
        icon.setOnClickListener(this)
        enter.setOnClickListener(this)
        info.setOnClickListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.add -> {
                val intent = Intent(this, AddEmployee::class.java)
                startActivity(intent)
            }
            R.id.news ->{
                val intent = Intent(this, Journal::class.java)
                startActivity(intent)
            }
        }
        return false
    }

    override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
        val mode = PorterDuff.Mode.SRC_IN

        if (motionEvent?.action==MotionEvent.ACTION_UP){
            //enter.setColorFilter(ContextCompat.getColor(this,R.color.hover), mode)
            icon.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), mode)
            enterTxt.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
            System.out.println("up")

        }else if (motionEvent?.action==MotionEvent.ACTION_DOWN){
            System.out.println("down")
            //enter.setColorFilter(ContextCompat.getColor(this,R.color.colorAccent), mode)
            icon.setColorFilter(ContextCompat.getColor(this, R.color.hover), mode)
            enterTxt.setTextColor(ContextCompat.getColor(this, R.color.hover))
        }
        return false
    }
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.enter ->recognize()
            R.id.icon->recognize()
            R.id.enterTxt ->recognize()
            R.id.info -> journal()
        }
    }

    private fun journal() {
        val intent = Intent(this, Journal::class.java)
        startActivity(intent)
    }

    private fun recognize() {
        val intent = Intent(this, Recognize::class.java)
        startActivityForResult(intent,0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
         data?.getIntExtra("type",-1).let {
             when(it){
                 IN ->{ Toast.makeText(this,resources.getString(R.string.enterrecorded),Toast.LENGTH_LONG).show() }
                 OUT ->{ Toast.makeText(this,resources.getString(R.string.exitrecorded),Toast.LENGTH_LONG).show() }
             }
         }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addPerson ->{
                val intent = Intent(this, AddEmployee::class.java)
                startActivity(intent)            }
        }
        return super.onOptionsItemSelected(item)

    }
}
