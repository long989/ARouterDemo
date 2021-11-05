package com.qkl.arouterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.button.MaterialButton
import com.qkl.arouterdemo.constants.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<MaterialButton>(R.id.to_detail).setOnClickListener {
            navigation(Constants.ROUTE_DETAILS)
        }
        findViewById<MaterialButton>(R.id.to_auth).setOnClickListener {
            navigation(Constants.ROUTE_AUTHENTICATION)
        }
        findViewById<MaterialButton>(R.id.to_vip).setOnClickListener {
            navigation(Constants.ROUTE_VIP)
        }
        findViewById<MaterialButton>(R.id.to_degrade).setOnClickListener {
            navigation("/profile/unknow")
        }
    }

    private fun navigation(path: String) {
        ARouter.getInstance().build(path).navigation()
    }
}