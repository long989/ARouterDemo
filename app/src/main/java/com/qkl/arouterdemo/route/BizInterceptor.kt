package com.qkl.arouterdemo.route

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import java.lang.RuntimeException

/**
 * @title:
 * @projectName NewDriverSchool
 * @description: ARouter拦截器
 * @author qiukailong
 * @date 2021/11/5
 */
@Interceptor(name = "biz_interceptor", priority = 9)
class BizInterceptor : IInterceptor {
    private var context: Context? = null
    override fun init(context: Context?) {
        this.context = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val flag = postcard!!.extra
        if (flag and (RouteFlag.FLAG_LOGIN) != 0) {
            callback!!.onInterrupt(RuntimeException("need login"))
            showToast("请先登录")
        } else if (flag and (RouteFlag.FLAG_AUTHENTICATION) != 0) {
            callback!!.onInterrupt(RuntimeException("need auth"))
            showToast("请先认证")
        } else if (flag and (RouteFlag.FLAG_VIP) != 0) {
            callback!!.onInterrupt(RuntimeException("need vip"))
            showToast("请先充钱成为vip")
        } else {
            callback!!.onContinue(postcard)
        }
    }

    private fun showToast(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

}