package com.lpc.kotlin2.ui.personal

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lpc.kotlin2.MainActivity
import com.lpc.kotlin2.R
import org.w3c.dom.Text

/**
 * Created by eml19 on 2017/5/21.
 */
class LoginActivity:AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        if (v!=null) {
            when (v.id) {
                R.id.btnLogin -> checkParam()
            }
        }

    }

    private fun checkParam() {

        var name = etName.text.toString()
        var pwd = etPwd.text.toString()
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show()
            return
        }
        login(name,pwd)
    }

    private fun login(name: String, pwd: String) {
        if (!TextUtils.equals(name,"kotlin") || !TextUtils.equals(pwd,"123456")) {
            Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this,"login Success",Toast.LENGTH_SHORT).show()

        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }

    private lateinit var etName :EditText
    private lateinit var etPwd :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }


    fun initView() {
        etName = findViewById(R.id.etName) as EditText
        etPwd = findViewById(R.id.etPwd) as EditText
        (findViewById(R.id.btnLogin) as Button).setOnClickListener(this)
    }
}