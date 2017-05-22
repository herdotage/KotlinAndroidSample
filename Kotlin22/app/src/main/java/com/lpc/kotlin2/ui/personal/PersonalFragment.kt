package com.lpc.kotlin2.ui.message

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
class PersonalFragment: Fragment() {

    private  lateinit  var personalFragment: PersonalFragment


    private fun PersonalFragment() {

    }

    fun getFragment(title:String): PersonalFragment {
//        if (personalFragment == null) {
            personalFragment = com.lpc.kotlin2.ui.message.PersonalFragment()
            val bundle = Bundle()
            bundle.putString("content",title)
            arguments = bundle
//        }
        return personalFragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return View.inflate(activity, R.layout.fragment_own,container)
        if (inflater!=null) {
            return inflater.inflate(R.layout.fragment_own, container, false)
        }else{
            return null
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    fun add(a:Int):Int {

        when(a) {
            1 ->  Log.d("lpc","")
            2 -> Toast.makeText(activity,"ttt", Toast.LENGTH_SHORT).show()
            else -> other()
        }


        return a+3
    }


    fun add(a:Int,b:Int) = a+b

    private fun other() {


    }
}