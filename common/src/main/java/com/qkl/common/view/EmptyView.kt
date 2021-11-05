package com.qkl.common.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qkl.common.R

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2021/11/5
 */
class EmptyView : LinearLayout {
    private var icon: ImageView? = null
    private var title: TextView? = null
    private var button: Button? = null

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0) {

    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER
        LayoutInflater.from(context).inflate(R.layout.layout_empty, this, true)
        icon = findViewById(R.id.empty_icon)
        title = findViewById(R.id.empty_text)
        button = findViewById(R.id.empty_action)
    }

    fun setIcon(iconRes: Int) {
        icon!!.setImageResource(iconRes)
    }

    fun setTitle(text: String) {
        title!!.text = text
        title!!.visibility = if (TextUtils.isDigitsOnly(text)) View.GONE else View.VISIBLE
    }

    fun setButton(text: String, listener: OnClickListener) {
        if (TextUtils.isEmpty(text)) {
            button!!.visibility = View.GONE
        } else {
            button!!.visibility = View.VISIBLE
            button!!.text = text
            button!!.setOnClickListener(listener)
        }
    }
}