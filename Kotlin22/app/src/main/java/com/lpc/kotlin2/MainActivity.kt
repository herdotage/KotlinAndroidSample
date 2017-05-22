package com.lpc.kotlin2

import android.annotation.SuppressLint
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import com.lpc.kotlin2.ui.home.HomeFragment
import com.lpc.kotlin2.ui.message.MessageFragment
import com.lpc.kotlin2.ui.message.PersonalFragment
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(p0: Int) {


    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {


    }

    override fun onPageSelected(p0: Int) {
        changeTab(p0)
        Log.d("lpc","page chagned to $p0")
    }


    private lateinit var flContent:FrameLayout
    private lateinit var vpContent:ViewPager
    private lateinit var adapter:FragmentPagerAdapter
//    private lateinit var fragments:MutableList<Fragment>
    private lateinit  var fragments:java.util.ArrayList<Fragment>
    private lateinit var navigation:BottomNavigationView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun  getF(index:Int):Fragment? {
        when(index) {
            0 -> return HomeFragment().getFragment(title_home)
            1 -> return MessageFragment().getFragment(title_message)
            2 -> return PersonalFragment().getFragment(title_personal)
            else -> return HomeFragment().getFragment(title_home)
        }
    }


    private val name by Delegates.observable("jane") {
        old,new,prop -> Log.d("lpc","name changed from $old to $new")
    }


    private fun initView() {

        navigation = findViewById(R.id.bnvNavigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(this)


        vpContent = findViewById(R.id.vpContent) as ViewPager
        val f = java.util.ArrayList<Fragment>()
        f.add(HomeFragment().getFragment("title"))

        var homeFragment = HomeFragment().getFragment(title_home)
        var messageFragment = MessageFragment().getFragment(title_message)
        var personalFragment = PersonalFragment().getFragment(title_personal)
//        if ( fragments.isEmpty()) {
        fragments = java.util.ArrayList<Fragment>()
        fragments.add(homeFragment)
        fragments.add(messageFragment)
        fragments.add(personalFragment)
        var size = fragments.size
        Log.d("lpc","fragment size $size")
//            fragments = mutableListOf(homeFragment,messageFragment,personalFragment)
//        }


//        var manager = supportFragmentManager
//        var transaction = manager.beginTransaction()
//        transaction.add(R.id.flContent,homeFragment, title_home)
//        transaction.commit()





        adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(i: Int): Fragment? {
                return fragments[i]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }

        vpContent.addOnPageChangeListener(this)

        vpContent.adapter = adapter
        vpContent.currentItem = 0

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

//        Log.d("lpc","goupId: "+p0.groupId)
//        Log.d("lpc","goupId: "+p0.itemId)
//        Log.d("lpc","goupId: "+p0.groupId)
//        when(p0.title) {
//            title_home -> changeTab(0)
//            title_message -> changeTab(1)
//            title_personal -> changeTab(2)
//        }

        when(p0.itemId) {
            R.id.nav_home -> {
                changeTab(0)
                return true
            }
            R.id.nav_message -> {
                changeTab(1)
                return true
            }
            R.id.nav_personal -> {
                changeTab(2)
                return true
            }

        }
       return false
    }

    private fun changeTab(index:Int) {
        Log.d("lpc","currentTab is $index ")
        vpContent.currentItem = index
//        hideFragment()
    }

    private fun hideFragment(transaction:FragmentTransaction) {
//        if ()
    }

    fun toast(msg:String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    
      companion object {
        var title_home = "home"
        var title_message = "message"
        var title_personal = "personal"
    }
}
