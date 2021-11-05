package com.qkl.arouterdemo.route

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @title:
 * @projectName NewDriverSchool
 * @description: 全局降级服务，当路由跳转的时候，目标页不存在，此时重定向到统一错误页
 * @author qiukailong
 * @date 2021/11/5
 */
@Route(path = "/degrade/global/service")
class DegradeServiceImpl : DegradeService {
    override fun init(context: Context?) {
        ARouter.getInstance().build("/degrade/global/activity").greenChannel().navigation()
    }

    override fun onLost(context: Context?, postcard: Postcard?) {
    }
}