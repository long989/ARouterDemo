package com.qkl.arouterdemo.route

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.qkl.arouterdemo.R
import com.qkl.common.view.EmptyView

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:全局统一的错误页
 * @author qiukailong
 * @date 2021/11/5
 */
@Route(path = "/degrade/global/activity")
class DegradeGlobalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_degrade_global)
        val emptyView = findViewById<EmptyView>(R.id.empty_view)
        emptyView.setTitle("页面出问题了，等一会再来试试看吧...")
        emptyView.setButton("试一试") {
            Toast.makeText(this, "试试就试试", Toast.LENGTH_LONG).show()
        }
    }
}