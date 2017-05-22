package com.lpc.kotlin2.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lpc.kotlin2.R

/**
 * Created by eml19 on 2017/5/21.
 */
class HomeFragment:Fragment() {

    private  lateinit  var homeFragment:HomeFragment


    fun getFragment(title:String):HomeFragment {

//        if (homeFragment == null) {
            homeFragment = com.lpc.kotlin2.ui.home.HomeFragment()
            val bundle = Bundle()
            bundle.putString("content",title)
            arguments = bundle
//        }
        return homeFragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (inflater!=null) {
            return inflater.inflate(R.layout.fragment_home, container, false)
        }else{
            return null
        }
//        return View.inflate(activity, R.layout.fragment_home,container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    fun add(a:Int):Int {

        when(a) {
            1 ->  Log.d("lpc","")
            2 -> Toast.makeText(activity,"ttt",Toast.LENGTH_SHORT).show()
            else -> other()
        }


        return a+3
    }


    fun add(a:Int,b:Int) = a+b

    private fun other() {


    }
}